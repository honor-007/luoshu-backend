package com.example.auth.granter;

import com.example.core.tool.context.ApplicationContextHolder;
import com.example.common.enums.GrantType;
import com.example.core.tool.exception.MSException;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;


/**
 * @author honor
 * <p>
 * 策略模式实现不同的登录验证方式
 */
@AllArgsConstructor
public class UserInfoGranterBuilder {
    private static final Map<GrantType, IUserInfoGranter> GRANTER_POOL = new HashMap<GrantType, IUserInfoGranter>();

    static {
        GRANTER_POOL.put(GrantType.PASSWORD, ApplicationContextHolder.getContext().getBean(PasswordUserInfoGranter.class));
        GRANTER_POOL.put(GrantType.PHONENUM, ApplicationContextHolder.getContext().getBean(PhoneNumUserInfoGranter.class));
    }

    public static IUserInfoGranter getUserInfoGranter(GrantType grantType) {
        IUserInfoGranter userInfoGranter = GRANTER_POOL.get(grantType);
        if (userInfoGranter == null) {
            throw new MSException("no grantType was found");
        } else {
            return userInfoGranter;
        }
    }
}
