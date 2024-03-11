package com.example.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.auth.entity.AuthInfo;
import com.example.auth.entity.User;
import com.example.auth.entity.UserInfo;
import com.example.auth.entity.UserParameter;
import com.example.auth.granter.IUserInfoGranter;
import com.example.auth.granter.TokenGranter;
import com.example.auth.granter.UserInfoGranterBuilder;
import com.example.core.tool.api.R;
import com.example.common.enums.GrantType;
//import io.swagger.annotations.ApiParam;
import com.example.core.tool.exception.MSException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author honor
 * @author Chill
 */
@RestController
@AllArgsConstructor
@RequestMapping("/auth/")
//@Api(value = "用户授权认证", tags = "授权接口")
public class AuthController {

    @PostMapping("token")
//    public R<AuthInfo> doLogin(@ApiParam(value = "授权类型", required = true) @RequestParam(defaultValue = "PASSWORD", required = false) GrantType grantType,
//                               @ApiParam(value = "租户ID", required = true) @RequestParam(defaultValue = "000000", required = false) String tenantId,
//                               @ApiParam(value = "账号") @RequestParam(required = false) String account,
//                               @ApiParam(value = "密码") @RequestParam(required = false) String password) {
    public R<AuthInfo> doLogin(@RequestParam(defaultValue = "PASSWORD", required = false) GrantType grantType,
                               @RequestParam(defaultValue = "000000", required = false) String tenantId,
                               @RequestParam(required = false) String account,
                               @RequestParam(required = false) String password) {

        UserParameter userParameter = UserParameter.builder()
                .tenantId(tenantId)
                .account(account)
                .password(password)
                .grantType(grantType)
                .build();

        //1.策略模式,兼容不同的登陆方式
        IUserInfoGranter userInfoGranter = UserInfoGranterBuilder.getUserInfoGranter(grantType);
        UserInfo userInfo = userInfoGranter.grant(userParameter);
        if (userInfo == null || userInfo.getUser() == null || userInfo.getUser().getId() == null) {
            return R.fail("用户名或密码错误");
        }
        //sa-token
        User user = userInfo.getUser();

        try {
            // 创建ObjectMapper对象
            ObjectMapper objectMapper = new ObjectMapper();
            // 将对象转换为JSON字符串
            String userJsonString = objectMapper.writeValueAsString(user);
            StpUtil.login(userJsonString);
        } catch (Exception e) {
            throw new MSException(e.getMessage());
        }


        return R.data(TokenGranter.createAuthInfo(userInfo));
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}
