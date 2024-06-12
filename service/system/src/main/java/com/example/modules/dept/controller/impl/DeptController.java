package com.example.modules.dept.controller.impl;

import com.example.core.tool.api.R;
import com.example.modules.dept.dao.criteria.DeptCriteria;
import com.example.modules.dept.dao.entity.Dept;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author honor
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/system/dept")
@OpenAPIDefinition(info = @Info(title = "菜单模块", description = "对用户进行操作", version = "1.0.0"))
@Tag(name = "dept")
public class DeptController {
    private final DeptService menuService;

    /**
     * 查询单条
     */
    @Operation(summary = "查看详情")
    @GetMapping("/detail")
    public R<DeptVO> detail(DeptCriteria criteria) {
        Dept detail = menuService.getOne(criteria);
        return R.data(DeptConvertMapper.INSTANT.from(detail));
    }

}
