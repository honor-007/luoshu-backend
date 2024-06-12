package com.example.auth.granter;


import com.example.core.secure.entity.UserInfo;
import com.example.core.secure.entity.UserParameter;

/**
 * @author honor
 */
public interface IUserInfoGranter {
    UserInfo grant(UserParameter userParameter);
}
