package com.example.modules.user.Req;

import com.example.core.mybatis.base.TenantEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.List;

/**
 * @author honor
 */

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserReq extends TenantEntity {
    private String id;

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
    private Instant birthday;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 角色id
     */
    private List<Long> roleId;
    /**
     * 部门id
     */
    private List<Long> deptId;
    /**
     * 部门id
     */
    private List<Long> postId;
}
