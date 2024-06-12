package com.example.modules.menu.manager;

import com.example.modules.menu.dao.criteria.MenuCriteria;
import com.example.modules.menu.dao.impl.MenuDAO;
import com.example.modules.menu.dao.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author honor
 */


@Service
@CacheConfig(cacheNames = {"MenuManager"})
@RequiredArgsConstructor
public class MenuManager {
    private final MenuDAO menuDAO;

    public Menu selectById(String id) {
        return menuDAO.getById(id);
    }

    public Menu selectOne(MenuCriteria criteria) {
        return menuDAO.selectOne(criteria);
    }

    public List<Menu> allMenu() {
        return menuDAO.allMenu();
    }

    public List<Menu> roleMenu(List<String> roleIds) {
        return menuDAO.roleMenu(roleIds);
    }
}
