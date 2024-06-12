package com.example.modules.user.manager;

import com.example.modules.user.dao.entity.Role;
import com.example.modules.user.dao.impl.RoleDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author honor
 */


@Service
@CacheConfig(cacheNames = {"RoleManager"})
@RequiredArgsConstructor
public class RoleManager {
    private final RoleDAO roleDAO;

    public List<Role> queryBatchIds(List<String> id) {
        return roleDAO.selectBatchIds(id);
    }


}
