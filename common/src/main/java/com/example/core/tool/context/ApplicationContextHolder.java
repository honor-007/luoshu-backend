package com.example.core.tool.context;

import com.example.core.tool.utils.RedisUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author honor
 *
 * 预先获取Spring上下文存于容器中
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationContextHolder.context == null) {
            ApplicationContextHolder.context = applicationContext;
        }
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static RedisUtils getRedisUtils() {
        return getContext().getBean(RedisUtils.class);
    }
}
