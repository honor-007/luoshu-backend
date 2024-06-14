package com.example.modules.user.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.modules.user.dao.criteria.UserCriteria;
import com.example.modules.user.dao.entity.User;
import com.example.modules.user.dao.impl.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author honor
 */


@Service
@CacheConfig(cacheNames = {"UserManager"})
@RequiredArgsConstructor
public class UserManager {
    private final UserDAO userDAO;

    public User selectById(String id) {
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

    public IPage<User> selectPage(UserCriteria criteria) {
        IPage<User> userIPage = userDAO.selectPage(criteria);
        List<User> collect = userIPage.getRecords().stream().filter(v -> v.getDeptId().contains(criteria.getDeptId())).toList();
        userIPage.setRecords(collect);
        userIPage.setTotal(collect.size());
        return userIPage;
    }
}
