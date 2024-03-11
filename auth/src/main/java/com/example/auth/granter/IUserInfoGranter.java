package com.example.auth.granter;

import com.example.auth.entity.UserInfo;
import com.example.auth.entity.UserParameter;
import org.springframework.util.LinkedCaseInsensitiveMap;

/**
 * @author honor
 */
public interface IUserInfoGranter {
    UserInfo grant(UserParameter userParameter);
}
