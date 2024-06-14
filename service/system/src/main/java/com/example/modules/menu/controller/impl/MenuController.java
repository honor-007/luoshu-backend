package com.example.modules.menu.controller.impl;

import com.example.core.secure.entity.SecureUser;
import com.example.core.secure.utils.SecureUtil;
import com.example.core.tool.api.R;
import com.example.modules.dept.controller.vo.DeptVO;
import com.example.modules.menu.controller.vo.MenuVO;
import com.example.modules.menu.dao.criteria.MenuCriteria;
import com.example.modules.menu.service.impl.MenuService;
import com.example.modules.menu.support.MenuConvertMapper;
import com.example.modules.menu.dao.entity.Menu;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author honor
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/system/menu")
@OpenAPIDefinition(info = @Info(title = "菜单模块", description = "对用户进行操作", version = "1.0.0"))
@Tag(name = "menu")
public class MenuController {
    private final MenuService menuService;

    /**
     * 查询单条
     */
    @Operation(summary = "查看详情")
    @GetMapping("/detail")
    public R<MenuVO> detail(MenuCriteria criteria) {
        Menu detail = menuService.getOne(criteria);
        return R.data(MenuConvertMapper.INSTANT.from(detail));
    }

    /**
     * 前端菜单数据
     */
    @Operation(summary = "前端菜单数据")
    @GetMapping("/routes")
    public R<List<MenuVO>> routes() {
        SecureUser secureUser = SecureUtil.getUser();
        List<MenuVO> list = menuService.routes((secureUser == null || Objects.equals(secureUser.getId(), "0")) ? null : secureUser.getRoleId());
        return R.data(list);
    }

    @Operation(summary = "当前用户的权限合集")
    @GetMapping("/user-menu-codes")
    public R<List<String>> userMenuCodeList() {
        SecureUser secureUser = SecureUtil.getUser();
        List<String> catalogCodeList = menuService.roleMenuCodeList((secureUser == null || Objects.equals(secureUser.getId(), "0")) ? null : secureUser.getRoleId());
        return R.data(catalogCodeList);
    }

    @Operation(summary = "当前用户的权限合集")
    @GetMapping("/all-menu-codes")
    public R<List<String>> allMenuCodeList() {
        List<String> allMenuCodeList = menuService.allMenuCodeList();
        return R.data(allMenuCodeList);
    }
}
