package com.example.modules.user.service.bo;

import com.example.modules.user.dao.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author honor
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户基础信息
     */
    @Schema(name = "用户")
    private User user;

    /**
     * 权限标识集合
     */
    @Schema(name = "权限集合")
    private List<String> permissions;

    /**
     * 角色集合
     */
    @Schema(name = "角色集合")
    private List<String> roles;

    /**
     * 第三方授权id
     */
    @Schema(name = "第三方授权id")
    private String oauthId;
}
