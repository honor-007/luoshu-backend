package com.example.demo.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.entity.User;
import com.example.demo.dao.mapper.UserMapper;
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
}
