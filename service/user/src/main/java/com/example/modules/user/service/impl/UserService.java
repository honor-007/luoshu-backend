package com.example.modules.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.core.mybatis.support.BaseEntityWrapper;
import com.example.core.secure.entity.AuthInfo;
import com.example.core.tool.exception.MSException;
import com.example.core.tool.utils.Func;
import com.example.modules.user.controller.vo.UserVO;
import com.example.modules.user.dao.criteria.UserCriteria;
import com.example.modules.user.dao.entity.Role;
import com.example.modules.user.manager.RoleManager;
import com.example.modules.user.manager.UserManager;
import com.example.modules.user.service.bo.UserInfo;
import com.example.modules.user.dao.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author honor
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserManager userManager;
    private final RoleManager roleManager;

    public User getById(String id) {
        return userManager.selectById(id);
    }

    public User getOne(User user) {
        return userManager.getOne(user);
    }

    public AuthInfo getCurrentUser(String id) {
        User user = userManager.selectById(id);
        List<String> roleIds = user.getRoleId();
        List<Role> roles = roleManager.queryBatchIds(roleIds);
        List<String> roleAlias = roles.stream().map(Role::getRoleAlias).collect(Collectors.toList());

        AuthInfo authInfo = new AuthInfo();
        authInfo.setUserId(user.getId());
        authInfo.setTenantId(user.getTenantId());
        authInfo.setAccount(user.getAccount());
        authInfo.setUserName(user.getRealName());
        authInfo.setAuthority(roleAlias.toString().substring(1, roleAlias.toString().length() - 1));
        authInfo.setTokenType("satoken");
        return authInfo;
    }

    public UserInfo userInfo(String userId) {
        UserInfo userInfo = new UserInfo();
        User user = userManager.selectById(userId);
        if (ObjectUtils.isEmpty(user)) {
            return null;
        }
        userInfo.setUser(user);
        if (ObjectUtils.isNotEmpty(user)) {
            List<String> roleIds = user.getRoleId();
            List<Role> roles = roleManager.queryBatchIds(roleIds);
            List<String> roleAlias = roles.stream().map(Role::getRoleAlias).collect(Collectors.toList());
            userInfo.setRoleAlias(roleAlias);
        }
        return userInfo;
    }

    /**
     * 使用账号密码登录验证
     *
     * @param account
     * @param password
     * @param tennatId
     * @return
     */
    public UserInfo signByPassword(String account, String password, String tennatId) {
        UserInfo userInfo = new UserInfo();
        User user = userManager.getOne(User.builder().account(account).tenantId(tennatId).build());
        if (ObjectUtils.isEmpty(user) || !passwordMatch(password, user)) {
            return null;
        }
        userInfo.setUser(user);
        if (ObjectUtils.isNotEmpty(user)) {
            List<String> roleIds = user.getRoleId();
            List<Role> roles = roleManager.queryBatchIds(roleIds);
            List<String> roleAlias = roles.stream().map(Role::getRoleAlias).collect(Collectors.toList());
            userInfo.setRoleAlias(roleAlias);
        }
        return userInfo;
    }

    private boolean passwordMatch(String password, User user) {
        return Objects.isNull(user) || new BCryptPasswordEncoder().matches(password, user.getPassword());
    }

    public boolean saveOrUpdate(User user) {
        if (ObjectUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
        Long cnt = userManager.selectCount(user);
        if (cnt > 0) {
            throw new MSException("当前用户已存在!");
        }
        return userManager.saveOrUpdate(user);
    }

    public boolean updateById(User user) {
        return userManager.updateById(user);
    }

    public boolean deleteBatchByIds(List<Long> ids) {
        return userManager.deleteBatchByIds(ids);
    }

    public IPage<User> page(UserCriteria criteria) {
        return userManager.selectPage(criteria);
    }
}
