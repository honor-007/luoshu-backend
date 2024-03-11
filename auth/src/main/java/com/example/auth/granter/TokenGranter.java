package com.example.auth.granter;


import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.example.auth.entity.AuthInfo;
import com.example.auth.entity.User;
import com.example.auth.entity.UserInfo;
import com.example.core.tool.utils.Func;

/**
 * @author honor
 */
public class TokenGranter {

    /**
     * 创建认证token
     *
     * @param userInfo 用户信息
     * @return token
     */
    public static AuthInfo createAuthInfo(UserInfo userInfo) {
        User user = userInfo.getUser();


        StpUtil.login(user.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();


        AuthInfo authInfo = new AuthInfo();
        authInfo.setUserId(user.getId());
        authInfo.setTenantId(Func.toStr(user.getTenantId()));
        authInfo.setOauthId(userInfo.getOauthId());
        authInfo.setAccount(user.getAccount());
        authInfo.setUserName(user.getRealName());
        authInfo.setAuthority(userInfo.getRoles().toString().substring(1, userInfo.getRoles().toString().length() - 1));
        authInfo.setAccessToken(tokenInfo.getTokenValue());
//        authInfo.setExpiresIn(accessToken.getExpire());
//        authInfo.setRefreshToken(createRefreshToken(userInfo).getToken());
        authInfo.setTokenType("satoken");
//        authInfo.setLicense(TokenConstant.LICENSE_NAME);

        return authInfo;
    }

}
