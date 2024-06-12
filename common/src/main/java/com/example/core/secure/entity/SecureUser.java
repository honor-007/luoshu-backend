package com.example.core.secure.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 实体类
 *
 * @author Chill
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecureUser {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    //@ApiModelProperty(value = "主键")
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    private String tenantId;
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
    private List<String> roleId;
    /**
     * 部门id
     */
    private List<String> deptId;
    /**
     * 部门id
     */
    private List<String> postId;


}