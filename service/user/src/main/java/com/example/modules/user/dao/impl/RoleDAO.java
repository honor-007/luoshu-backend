package com.example.modules.user.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.modules.user.dao.mapper.RoleMapper;
import com.example.modules.user.dao.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author honor
 */
@Repository
public class RoleDAO extends ServiceImpl<RoleMapper, Role> {

    public List<Role> selectBatchIds(List<String> ids) {
        return baseMapper.selectBatchIds(ids);
    }

}
