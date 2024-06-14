package com.example.modules.dept.controller.impl;

import com.example.core.tool.api.R;
import com.example.core.tool.node.TreeNode;
import com.example.modules.dept.service.impl.DeptService;
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

/**
 * @author honor
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/system/dept")
@OpenAPIDefinition(info = @Info(title = "部门模块", description = "部门模块", version = "1.0.0"))
@Tag(name = "dept")
public class DeptController {
    private final DeptService deptService;

    /**
     * 查询单条
     */
//    @Operation(summary = "查看详情")
//    @GetMapping("/detail")
//    public R<DeptVO> detail(DeptCriteria criteria) {
//        Dept detail = deptService.getOne(criteria);
//        return R.data(DeptConvertMapper.INSTANT.from(detail));
//    }

    /**
     * 获取部门树形结构
     *
     * @return
     */
    @GetMapping("/tree")
    @Operation(summary = "树形结构")
    public R<List<TreeNode>> tree() {
        List<TreeNode> tree = deptService.tree();
        return R.data(tree);
    }
}
