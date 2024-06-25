package com.example.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.auth.granter.IUserInfoGranter;
import com.example.auth.granter.TokenGranter;
import com.example.auth.granter.UserInfoGranterBuilder;
import com.example.core.secure.entity.AuthInfo;
import com.example.core.secure.entity.SecureUser;
import com.example.core.secure.entity.UserInfo;
import com.example.core.secure.entity.UserParameter;
import com.example.core.tool.api.R;
import com.example.core.tool.exception.MSException;
import com.example.core.tool.utils.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author honor
 * @author Chill
 */
@RestController
@RequestMapping("/api/auth/")
@OpenAPIDefinition(info = @Info(title = "用户授权认证", description = "授权接口", version = "1.0.0"))
@Tag(name = "auth")
public class AuthController {

    @Resource
    RedisUtils redisUtils;

    @Value("${sa-token.timeout}")
    private long tokenTimeOut;

    @PostMapping("login")
    public R<AuthInfo> doLogin(@RequestBody(required = false) UserParameter loginInfo) {
        UserParameter userParameter = UserParameter.builder()
                .tenantId(loginInfo.getTenantId())
                .account(loginInfo.getAccount())
                .password(loginInfo.getPassword())
                .grantType(loginInfo.getGrantType())
                .build();

        //1.策略模式,兼容不同的登陆方式
        IUserInfoGranter userInfoGranter = UserInfoGranterBuilder.getUserInfoGranter(loginInfo.getGrantType());
        UserInfo userInfo = userInfoGranter.grant(userParameter);
        if (userInfo == null || userInfo.getSecureUser() == null || userInfo.getSecureUser().getId() == null) {
            return R.fail("用户名或密码错误");
        }
        //sa-token
        SecureUser secureUser = userInfo.getSecureUser();

        //将用户信息存入redis
        redisUtils.<SecureUser>setCacheObject(secureUser.getId(), secureUser, tokenTimeOut, TimeUnit.SECONDS);
        try {
            // 创建ObjectMapper对象
            ObjectMapper objectMapper = new ObjectMapper();
            // 将对象转换为JSON字符串
            String userJsonString = objectMapper.writeValueAsString(secureUser);
            StpUtil.login(userJsonString);
        } catch (Exception e) {
            throw new MSException(e.getMessage());
        }

        return R.data(TokenGranter.createAuthInfo(userInfo));
    }

    @PostMapping("login-out")
    public R<String> loginOut(){
        StpUtil.logout();
        return R.success("退出成功");
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }


}
