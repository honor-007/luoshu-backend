package com.example.modules.dept.manager;


import com.example.core.tool.node.TreeNode;
import com.example.modules.dept.dao.criteria.DeptCriteria;
import com.example.modules.dept.dao.entity.Dept;
import com.example.modules.dept.dao.impl.DeptDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author honor
 */


@Service
@CacheConfig(cacheNames = {"DeptManager"})
@RequiredArgsConstructor
public class DeptManager {
    private final DeptDAO deptDAO;

    public Dept selectById(String id) {
        return deptDAO.getById(id);
    }


    public List<Dept> seletList(DeptCriteria criteria) {
        return deptDAO.selectList(criteria);
    }

    public List<TreeNode> tree(String tennatId) {
        return deptDAO.tree(tennatId);
    }

    public List<Dept> listByIds(List<String> ids){
        return deptDAO.listByIds(ids);
    }
}
