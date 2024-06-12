package com.example.core.secure.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.example.core.secure.entity.SecureUser;
import com.example.core.tool.context.ApplicationContextHolder;
import com.example.core.tool.exception.MSException;
import com.example.core.tool.utils.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author honor
 */

@Component
@AllArgsConstructor
public class SecureUtil {

    private final RedisUtils redisUtils;

    private static RedisUtils redisUtilsTemp;

    @PostConstruct
    private void init() {
        redisUtilsTemp = redisUtils;
    }

    public static SecureUser getUser() {
        SecureUser secureUser;
        try {
            String userString = StpUtil.getLoginIdAsString();
            RedisUtils redisUtils = ApplicationContextHolder.getRedisUtils();
            secureUser = redisUtils.<SecureUser>getCacheObject(userString);
        } catch (Exception e) {
            throw new MSException(e.getMessage(), e);
        }
        return secureUser;
    }

//    @Data
//    @Builder
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class SecureUser implements Serializable {
//        private static final long serialVersionUID = 1L;
//
//        private String clientId;
//
//        private Long userId;
//
//        private String tenantId;
//
//        private List<String> deptId;
//
//        private String userName;
//
//        private String account;
//
//        private List<String> roleId;
//
//        private String roleName;
//    }
}
