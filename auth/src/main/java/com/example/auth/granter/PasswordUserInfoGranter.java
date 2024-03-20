package com.example.auth.granter;

import com.example.auth.entity.UserInfo;
import com.example.auth.entity.UserParameter;
import com.example.auth.support.AuthConvertMapper;
import com.example.core.tool.api.R;
import com.example.modules.user.Rep.UserInfoRep;
import com.example.modules.user.feign.IUserClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author honor
 * <p>
 * 账号密码登录实现
 */
@Component
@AllArgsConstructor
public class PasswordUserInfoGranter implements IUserInfoGranter {

    private final IUserClient userClient;

    @Override
    public UserInfo grant(UserParameter userParameter) {
        String tenantId = userParameter.getTenantId();
        String account = userParameter.getAccount();
        String password = userParameter.getPassword();
        R<UserInfoRep> userInfoRepR = userClient.signByPassword(account, password, tenantId);
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if (userInfoRepR.isSuccess()) {
            UserInfoRep userInfoRep = userInfoRepR.getData();
            return UserInfo.builder()
                    .user(AuthConvertMapper.INSTANT.from(userInfoRep.getUser()))
                    .roles(userInfoRep.getRoles())
                    .build();
        }
        return null;
    }
}
