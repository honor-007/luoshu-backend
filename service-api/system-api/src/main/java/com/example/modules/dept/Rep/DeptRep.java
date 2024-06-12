package com.example.modules.dept.Rep;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * @author honor
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeptRep implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户基础信息
     */
    private UserRep user;

    /**
     * 权限标识集合
     */
    private List<String> permissions;

    /**
     * 角色集合
     */
    private List<String> roles;

    /**
     * 第三方授权id
     */
    private String oauthId;

    @EqualsAndHashCode
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserRep {
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
}