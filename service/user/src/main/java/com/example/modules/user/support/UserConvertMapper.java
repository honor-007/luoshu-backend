package com.example.modules.user.support;


import com.example.core.secure.utils.SecureUtil;
import com.example.modules.user.Rep.UserInfoRep;
import com.example.modules.user.Req.UserReq;
import com.example.modules.user.controller.vo.UserVO;
import com.example.modules.user.dao.entity.User;
import com.example.modules.user.service.bo.UserInfo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author honor
 */
@Mapper(builder = @Builder(disableBuilder = true))
public interface UserConvertMapper {
    UserConvertMapper INSTANT = Mappers.getMapper(UserConvertMapper.class);

    UserVO from(User user);

    UserInfoRep from(UserInfo userInfo);

    User from(UserReq userReq);

    User from(SecureUtil.User user);
}
