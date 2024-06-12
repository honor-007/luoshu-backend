package com.example.modules.dept.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author honor
 */
@FeignClient(
        value = "system-service",
        fallback = IDeptClientFallback.class
)
public interface IDeptClient {

    String API_PREFIX = "/user";


}
