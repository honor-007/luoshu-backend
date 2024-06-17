package com.example.modules.dept.feign;

import com.example.core.tool.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author honor
 */
@FeignClient(
        value = "system-service",
        fallback = IDeptClientFallback.class,
        contextId="dept"
)
public interface IDeptClient {

    String API_PREFIX = "/dept";

    /**
     * 根据id获取dept的name
     *
     * @param deptIds 部门ids
     * @return
     */
    @GetMapping(API_PREFIX + "/dept-names-by-id")
    public R<List<String>> getDeptNames(@RequestParam("deptIds") List<String> deptIds) ;
}
