package com.example.modules.menu.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.modules.menu.dao.criteria.MenuCriteria;
import com.example.modules.menu.dao.entity.Menu;
import com.example.modules.menu.dao.enums.MenuTypeEnum;
import com.example.modules.menu.dao.mapper.MenuMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * @author honor
 */
@Repository
public class MenuDAO extends ServiceImpl<MenuMapper, Menu> {

    public LambdaQueryWrapper<Menu> buildWrapper(MenuCriteria criteria) {
        LambdaQueryWrapper<Menu> queryWrapper = Wrappers.<Menu>lambdaQuery();
        if (Objects.nonNull(criteria)) {
            queryWrapper.eq(ObjectUtils.isNotEmpty(criteria.getId()), Menu::getId, criteria.getId());
        }
        return queryWrapper;
    }

    public Menu selectOne(MenuCriteria criteria) {
        return baseMapper.selectOne(buildWrapper(criteria));
    }

    public List<Menu> allMenu() {
        return baseMapper.allMenu(MenuTypeEnum.CATALOG);
    }

    public List<Menu> roleMenu(List<String> roleIds) {
        return baseMapper.roleMenu(roleIds);
    }
}
