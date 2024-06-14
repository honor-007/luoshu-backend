package com.example.modules.dept.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.core.tool.node.TreeNode;
import com.example.modules.dept.dao.criteria.DeptCriteria;
import com.example.modules.dept.dao.mapper.DeptMapper;
import com.example.modules.dept.dao.entity.Dept;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * @author honor
 */
@Repository
public class DeptDAO extends ServiceImpl<DeptMapper, Dept> {

    public LambdaQueryWrapper<Dept> buildWrapper(DeptCriteria criteria) {
        LambdaQueryWrapper<Dept> queryWrapper = Wrappers.<Dept>lambdaQuery();
        if (Objects.nonNull(criteria)) {
            queryWrapper.eq(ObjectUtils.isNotEmpty(criteria.getId()), Dept::getId, criteria.getId());
            queryWrapper.eq(ObjectUtils.isNotEmpty(criteria.getTenantId()), Dept::getTenantId, criteria.getTenantId());
        }
        return queryWrapper;
    }

    public Dept selectOne(DeptCriteria criteria) {
        return baseMapper.selectOne(buildWrapper(criteria));
    }

    public List<Dept> selectList(DeptCriteria criteria) {
        return baseMapper.selectList(buildWrapper(criteria));
    }


    public List<TreeNode> tree(String tennatId) {
        return baseMapper.tree(tennatId);
    }
}
