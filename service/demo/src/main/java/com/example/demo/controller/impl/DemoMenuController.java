package com.example.demo.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author honor
 */
@RestController
@AllArgsConstructor
@RequestMapping("/menu")
//@Api(value = "菜单", tags = "菜单")
public class DemoMenuController {

    /**
     * 前端菜单数据
     */
//    @GetMapping("/routes")
////    @ApiOperationSupport(order = 7)
////    @ApiOperation(value = "前端菜单数据", notes = "前端菜单数据")
//    public R<List<MenuVO>> routes(UserInfo user) {
//        List<MenuVO> list = menuService.routes((user == null || user.getUserId() == 0L) ? null : user.getRoleId());
//        return R.data(list);
//    }
}
