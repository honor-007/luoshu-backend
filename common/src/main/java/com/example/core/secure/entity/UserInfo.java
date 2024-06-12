package com.example.core.secure.entity;

//import io.swagger.annotations.ApiModelProperty;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author honor
 */
@Data
@Builder
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户基础信息
     */
    //@ApiModelProperty(value = "用户")
    private SecureUser secureUser;

    /**
     * 权限标识集合
     */
    //@ApiModelProperty(value = "权限集合")
    private List<String> permissions;

    /**
     * 角色集合
     */
    //@ApiModelProperty(value = "角色集合")
    private List<String> roleAlias;

    /**
     * 第三方授权id
     */
    //@ApiModelProperty(value = "第三方授权id")
    private String oauthId;
}
