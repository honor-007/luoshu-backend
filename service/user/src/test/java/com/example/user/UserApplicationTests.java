package com.example.user;

import com.example.core.tool.utils.RedisUtils;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class UserApplicationTests {
    @Resource
    RedisUtils redisUtils;

    @Test
    void testOne() {
        redisUtils.setCacheObject("test", "hello world", 60L, TimeUnit.SECONDS);
    }

}
