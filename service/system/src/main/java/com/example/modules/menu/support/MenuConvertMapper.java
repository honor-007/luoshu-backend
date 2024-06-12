package com.example.modules.menu.support;


import com.example.modules.menu.controller.vo.MenuVO;
import com.example.modules.menu.dao.criteria.MenuCriteria;
import com.example.modules.menu.dao.entity.Menu;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author honor
 */
@Mapper(builder = @Builder(disableBuilder = true))
public interface MenuConvertMapper {
    MenuConvertMapper INSTANT = Mappers.getMapper(MenuConvertMapper.class);

    MenuVO from(Menu user);

    List<MenuVO> convertToVOList(List<Menu> users);

    MenuCriteria convertToCriteria(Menu user);

//    UserInfoRep from(MenuInfo userInfo);
//
//    Dept from(MenuReq userReq);

}
