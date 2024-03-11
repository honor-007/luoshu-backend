package com.example.modules.user.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.modules.user.dao.entity.User;
import com.example.modules.user.dao.impl.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author honor
 */


@Service
@CacheConfig(cacheNames = {"UserManager"})
@RequiredArgsConstructor
public class UserManager {
    private final UserDAO userDAO;

    public User selectById(Long id) {
        return userDAO.getById(id);
    }

    public User getOne(User user) {
        return userDAO.getOne(new QueryWrapper<>(user));
    }

    public Long selectCount(User user) {
        return userDAO.selectCount(user);
    }

    public boolean saveOrUpdate(User user) {
        return userDAO.saveOrUpdate(user);
    }

    public boolean updateById(User user) {
        return userDAO.updateById(user);
    }

    public boolean deleteBatchByIds(List<Long> ids) {
        return userDAO.removeBatchByIds(ids);

    }
}
