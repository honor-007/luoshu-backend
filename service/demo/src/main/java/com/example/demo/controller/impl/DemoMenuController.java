package com.example.demo.controller.impl;

import com.example.core.tool.api.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author honor
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/demo")
//@Api(value = "菜单", tags = "菜单")
public class DemoMenuController {

    /**
     * 前端菜单数据
     */
    @GetMapping("/test")
    public R routes() {
        return R.data("test success");
    }
}
