package com.example.core.secure.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.example.core.tool.exception.MSException;
import com.example.core.tool.utils.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author honor
 */

@Component
@AllArgsConstructor
public class SecureUtil {

    public static User getUser() {
        User user;
        try {
            String userString = StpUtil.getLoginIdAsString();
            // 创建ObjectMapper对象
            ObjectMapper objectMapper = new ObjectMapper();
            // 将JSON字符串转换为Java对象
            user = objectMapper.readValue(userString, User.class);
        } catch (Exception e) {
            throw new MSException(e.getMessage(), e);
        }
        return user;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User implements Serializable {
        private static final long serialVersionUID = 1L;

        private String clientId;

        private Long userId;

        private String tenantId;

        private String deptId;

        private String userName;

        private String account;

        private String roleId;

        private String roleName;
    }
}
