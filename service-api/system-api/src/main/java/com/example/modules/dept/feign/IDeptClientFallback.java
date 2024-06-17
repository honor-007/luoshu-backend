package com.example.modules.dept.feign;

import com.example.core.tool.api.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign失败配置
 *
 * @author honor
 */
@Component
public class IDeptClientFallback {

    public R<List<String>> getDeptNames(@RequestParam("deptIds") List<String> deptIds) {
        return R.fail("未获取到账号信息");
    }
}
