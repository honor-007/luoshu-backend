package com.example.demo.service.impl;

import com.example.demo.dao.entity.User;
import com.example.demo.manager.UserManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author honor
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserManager userManager;

    public User getById(Long id) {
        return userManager.getById(id);
    }

    public User selectByTenantId() {
        return userManager.selectByTenantId();
    }

    public void insertDemo(User user) {
        userManager.insertDemo(user);
    }
}
