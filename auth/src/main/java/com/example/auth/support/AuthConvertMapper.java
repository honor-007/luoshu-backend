package com.example.auth.support;


import com.example.core.secure.entity.SecureUser;
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

    SecureUser from(UserInfoRep.UserRep userRep);

}
