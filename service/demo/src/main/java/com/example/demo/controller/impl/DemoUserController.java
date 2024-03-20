package com.example.demo.controller.impl;

import com.example.demo.dao.entity.User;
import com.example.demo.service.impl.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author honor
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("demo")
public class DemoUserController {
    private final UserService userService;

    @Operation(summary = "查看详情")
    @GetMapping("user/{id}")
    public User getUser(@PathVariable(value = "id") Long id) {
        if (ObjectUtils.isEmpty(id)) {
            return null;
        }
        return userService.getById(id);
    }

    @PostMapping("user")
    public void insertUser() {
        userService.insertDemo(User.builder().id("test1").tenantId("test1").build());
    }
}
