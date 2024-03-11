package com.example.demo.manager;

import com.example.demo.dao.entity.User;
import com.example.demo.dao.impl.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * @author honor
 */


@Service
@CacheConfig(cacheNames = {"UserManager"})
@RequiredArgsConstructor
public class UserManager {
    private final UserDAO userDAO;

    public User getById(Long id) {
        return userDAO.getById(id);
    }

    public User selectByTenantId() {
        return userDAO.selectByTenantId();
    }

    public void insertDemo(User user) {
        userDAO.insertUser(user);
    }
}
