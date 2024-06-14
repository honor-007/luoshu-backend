package com.example.modules.dept.service.impl;

import com.example.core.secure.utils.SecureUtil;
import com.example.core.tool.node.ForestNodeMerger;
import com.example.core.tool.node.TreeNode;
import com.example.modules.dept.manager.DeptManager;
import com.example.modules.dept.dao.entity.Dept;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author honor
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DeptService {
    private final DeptManager deptManager;

    public Dept getById(String id) {
        return deptManager.selectById(id);
    }


    public List<TreeNode> tree() {
        String tenantId = SecureUtil.getUser().getTenantId();
        List<TreeNode> deptTreeNodes = deptManager.tree(tenantId);
        return ForestNodeMerger.merge(deptTreeNodes);
    }

    public List<String> getDeptNames(List<String> ids) {
        List<Dept> depts = deptManager.listByIds(ids);
        if (CollectionUtils.isEmpty(depts))
            return Lists.newArrayList();
        return depts.stream().map(Dept::getDeptName).toList();
    }


}
