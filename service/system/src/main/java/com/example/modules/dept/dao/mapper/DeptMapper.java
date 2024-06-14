package com.example.modules.dept.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.core.tool.node.TreeNode;
import com.example.modules.dept.dao.entity.Dept;

import java.util.List;

/**
 * @author honor
 */
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * 获取树形节点
     *
     * @param tenantId
     * @return
     */
    List<TreeNode> tree(String tenantId);

}
