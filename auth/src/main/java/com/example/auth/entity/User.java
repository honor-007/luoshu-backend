package com.example.auth.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 实体类
 *
 * @author Chill
 */
@Data
@Builder
//@TableName("blade_user")
public class User {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    //@ApiModelProperty(value = "主键")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private Long tenantId;
    /**
     * 编号
     */
    private String code;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String name;
    /**
     * 真名
     */
    private String realName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String phone;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 部门id
     */
    private String postId;


}