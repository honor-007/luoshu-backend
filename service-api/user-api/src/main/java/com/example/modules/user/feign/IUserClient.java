package com.example.modules.user.feign;

import com.example.core.tool.api.R;
import com.example.modules.user.Rep.UserInfoRep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author honor
 */
@FeignClient(
        value = "user-service",
        fallback = IUserClientFallback.class
)
public interface IUserClient {

    String API_PREFIX = "/user";

    /**
     * 获取用户信息
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping(API_PREFIX + "/user-info-by-id")
    R<UserInfoRep> userInfo(@RequestParam("userId") Long userId);

    /**
     * 获取用户信息
     *
     * @param account
     * @param pwd
     * @param tennatId
     * @return
     */
    @GetMapping(API_PREFIX + "/sign-by-password")
    R<UserInfoRep> signByPassword(@RequestParam("account") String account, @RequestParam("pwd") String pwd, @RequestParam("tennatId") String tennatId);
}
