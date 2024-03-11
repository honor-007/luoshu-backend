package com.example.auth.entity;

import com.example.common.enums.GrantType;
import lombok.Builder;
import lombok.Data;

/**
 * @author honor
 */
@Data
@Builder
public class UserParameter {
    private String account;
    private String password;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 授权类型
     */
    private GrantType grantType;
    /**
     * 刷新令牌
     */
    private String refreshToken;
}
