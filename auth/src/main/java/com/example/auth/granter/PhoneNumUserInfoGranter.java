package com.example.auth.granter;

import com.example.auth.entity.UserInfo;
import com.example.auth.entity.UserParameter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedCaseInsensitiveMap;

/**
 * @author honor
 * <p>
 * 账号密码登录实现
 */
@Component
@AllArgsConstructor
public class PhoneNumUserInfoGranter implements IUserInfoGranter {

    @Override
    public UserInfo grant(UserParameter userParameter) {
        //TODO
        return null;
    }
}
