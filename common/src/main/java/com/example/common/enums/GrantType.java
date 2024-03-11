package com.example.common.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GrantType {
    PASSWORD("密码登录"),
    PHONENUM("手机号登录");

    @Getter
    private final String desc;
}
