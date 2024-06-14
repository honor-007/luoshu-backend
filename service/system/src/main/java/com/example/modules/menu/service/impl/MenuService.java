package com.example.modules.menu.service.impl;

import com.example.core.tool.node.ForestNodeMerger;
import com.example.modules.menu.controller.vo.MenuVO;
import com.example.modules.menu.dao.criteria.MenuCriteria;
import com.example.modules.menu.dao.enums.MenuTypeEnum;
import com.example.modules.menu.support.MenuConvertMapper;
import com.example.modules.dept.controller.vo.DeptVO;
import com.example.modules.menu.dao.entity.Menu;
import com.example.modules.menu.manager.MenuManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author honor
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MenuService {
    private final MenuManager menuManager;

    public Menu getById(String id) {
        return menuManager.selectById(id);
    }

    public Menu getOne(MenuCriteria criteria) {
        return menuManager.selectOne(criteria);
    }

    public List<MenuVO> routes(List<String> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            return null;
        }
        List<Menu> allMenus = menuManager.allMenu();
        List<Menu> roleMenus = menuManager.roleMenu(roleIds);
        List<Menu> routes = new LinkedList<>(roleMenus);
        roleMenus.forEach(roleMenu -> recursion(allMenus, routes, roleMenu));
        routes.sort(Comparator.comparing(Menu::getSort));
        List<Menu> collect = routes.stream().filter(x -> MenuTypeEnum.CATALOG.equals(x.getType())).collect(Collectors.toList());
        List<MenuVO> menuVOs = MenuConvertMapper.INSTANT.convertToVOList(collect);
        return ForestNodeMerger.merge(menuVOs);
    }

    public List<String> roleMenuCodeList(List<String> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            return null;
        }
        List<Menu> roleMenus = menuManager.roleMenu(roleIds);
        return roleMenus.stream().map(Menu::getCode).toList();
    }

    public List<String> allMenuCodeList() {
        List<Menu> allMenus = menuManager.allMenu();
        return allMenus.stream().map(Menu::getCode).toList();
    }

    public void recursion(List<Menu> allMenus, List<Menu> routes, Menu roleMenu) {
        Optional<Menu> menu = allMenus.stream().filter(x ->x.getId().equals(roleMenu.getParentId())).findFirst();
        if (menu.isPresent() && !routes.contains(menu.get())) {
            routes.add(menu.get());
            recursion(allMenus, routes, menu.get());
        }
    }

}
