package com.example.auth.granter;


import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.example.core.secure.entity.AuthInfo;
import com.example.core.secure.entity.SecureUser;
import com.example.core.secure.entity.UserInfo;
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
        SecureUser secureUser = userInfo.getSecureUser();


        StpUtil.login(secureUser.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        AuthInfo authInfo = new AuthInfo();
        authInfo.setUserId(secureUser.getId());
        authInfo.setTenantId(secureUser.getTenantId());
        authInfo.setOauthId(userInfo.getOauthId());
        authInfo.setAccount(secureUser.getAccount());
        authInfo.setUserName(secureUser.getRealName());
        authInfo.setAuthority(userInfo.getRoleAlias().toString().substring(1, userInfo.getRoleAlias().toString().length() - 1));
        authInfo.setAccessToken(tokenInfo.getTokenValue());
//        authInfo.setExpiresIn(accessToken.getExpire());
//        authInfo.setRefreshToken(createRefreshToken(userInfo).getToken());
        authInfo.setTokenType("satoken");
//        authInfo.setLicense(TokenConstant.LICENSE_NAME);

        return authInfo;
    }

}
