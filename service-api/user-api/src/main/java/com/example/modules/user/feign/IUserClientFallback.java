package com.example.modules.user.feign;

import com.example.core.tool.api.R;
import com.example.modules.user.Rep.UserInfoRep;
import org.springframework.stereotype.Component;

/**
 * Feign失败配置
 *
 * @author honor
 */
@Component
public class IUserClientFallback implements IUserClient {

    @Override
    public R<UserInfoRep> userInfo(Long userId) {
        return R.fail("未获取到账号信息");
    }

    @Override
    public R<UserInfoRep> signByPassword(String account, String pwd,String tennatId) {
        return R.fail("未获取到账号信息");
    }
}
