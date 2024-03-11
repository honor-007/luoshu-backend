package com.example.modules.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.modules.user.dao.entity.User;
import com.example.modules.user.dao.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * @author honor
 */
@Repository
public class UserDAO extends ServiceImpl<UserMapper, User> {

    public User selectByTenantId() {
        return baseMapper.selectByTenantId();
    }

    public void insertUser(User user) {
        baseMapper.insert(user);
    }

    public Long selectCount(User user) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getTenantId, user.getTenantId()).eq(User::getAccount, user.getAccount());
        return baseMapper.selectCount(queryWrapper);
    }
}
