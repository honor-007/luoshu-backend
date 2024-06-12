package com.example.modules.menu.service.bo;

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
public class MenuInfo implements Serializable {

    private static final long serialVersionUID = 1L;


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
