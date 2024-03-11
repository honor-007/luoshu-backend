package com.example.auth.support;


import com.example.auth.entity.User;
import com.example.modules.user.Rep.UserInfoRep;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author honor
 */
@Mapper(builder = @Builder(disableBuilder = true))
public interface AuthConvertMapper {
    AuthConvertMapper INSTANT = Mappers.getMapper(AuthConvertMapper.class);

    User from(UserInfoRep.UserRep userRep);

}
