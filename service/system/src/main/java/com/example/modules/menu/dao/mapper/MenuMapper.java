package com.example.modules.menu.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.modules.menu.dao.entity.Menu;
import com.example.modules.menu.dao.enums.MenuTypeEnum;

import java.util.List;

/**
 * @author honor
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     *
     * @return
     */
    Menu selectByTenantId();

    /**
     * 所有菜单
     *
     * @return
     */
    List<Menu> allMenu(MenuTypeEnum type);

    /**
     * 权限配置菜单
     *
     * @param roleId
     * @return
     */
    List<Menu> roleMenu(List<String> roleId);
}
