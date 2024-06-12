package com.example.gateway.conf;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Sa-Token 权限认证] 配置类
 *
 * @author honor
 */
@Configuration
public class SaTokenConfigure {
    // 注册 Sa-Token全局过滤器
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")    /* 拦截全部path */
                // 开放地址
                .addExclude("/favicon.ico")
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由，并排除/auth/token 用于开放登录
                    SaRouter.match("/**", "/api/auth/login", r -> StpUtil.checkLogin());
//                    SaRouter.match("/**", "/test", r -> StpUtil.checkLogin());

                    // 权限认证 -- 不同模块, 校验不同权限
                    SaRouter.match("/api/user/**", r -> StpUtil.checkPermission("user"));
                    SaRouter.match("/api/demo/**", r -> StpUtil.checkPermission("demo"));
                    SaRouter.match("/api/admin/**", r -> StpUtil.checkPermission("admin"));
                    SaRouter.match("/api/goods/**", r -> StpUtil.checkPermission("goods"));
                    SaRouter.match("/api/orders/**", r -> StpUtil.checkPermission("orders"));

                    // 更多匹配 ...  */
                })
                // 异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> {
                    return SaResult.error(e.getMessage());
                });
    }

}
