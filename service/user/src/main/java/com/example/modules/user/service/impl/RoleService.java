package com.example.modules.user.service.impl;

import com.example.modules.user.dao.entity.Role;
import com.example.modules.user.dao.entity.User;
import com.example.modules.user.manager.RoleManager;
import com.example.modules.user.service.bo.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author honor
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {
    private final RoleManager roleManager;

    public List<Role> queryBatchIds(List<String> ids) {
        return roleManager.queryBatchIds(ids);
    }


}
