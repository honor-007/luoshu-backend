package com.example.modules.menu.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author honor
 */
@FeignClient(
        value = "system-service",
        fallback = IMenuClientFallback.class
)
public interface IMenuClient {

    String API_PREFIX = "/user";


}