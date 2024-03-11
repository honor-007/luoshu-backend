/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.modules.user.feign;

import com.example.core.tool.api.R;
import com.example.modules.user.service.bo.UserInfo;
import com.example.modules.user.service.impl.UserService;
import com.example.modules.user.Rep.UserInfoRep;
import com.example.modules.user.support.UserConvertMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务Feign实现类
 *
 * @author Chill
 */
@RestController
@RequiredArgsConstructor
public class UserClient implements IUserClient {

    private final UserService service;

    @Override
    public R<UserInfoRep> userInfo(Long userId) {
        UserInfo userInfo = service.userInfo(userId);
        return R.data(UserConvertMapper.INSTANT.from(userInfo));
    }

    @Override
    public R<UserInfoRep> signByPassword(String account, String pwd,String tennatId) {
        UserInfo userInfo = service.signByPassword(account,pwd,tennatId);
        if (ObjectUtils.isEmpty(userInfo)) {
            return R.fail("未查询到用户信息");
        }
        UserInfoRep userInfoRep = UserConvertMapper.INSTANT.from(userInfo);
        return R.data(userInfoRep);
    }

//	@Override
//	@GetMapping(API_PREFIX + "/user-info")
//	public R<UserInfo> userInfo(String tenantId, String account, String password) {
//		return R.data(service.userInfo(tenantId, account, password));
//	}
//
//	@Override
//	@PostMapping(API_PREFIX + "/user-auth-info")
//	public R<UserInfo> userAuthInfo(UserOauth userOauth) {
//		return R.data(service.userInfo(userOauth));
//	}
//
//	@Override
//	@PostMapping(API_PREFIX + "/save-user")
//	public R<Boolean> saveUser(User user) {
//		return R.data(service.save(user));
//	}

}
