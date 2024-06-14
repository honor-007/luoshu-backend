package com.example.modules.dept.support;



import com.example.modules.dept.controller.vo.DeptVO;
import com.example.modules.dept.dao.criteria.DeptCriteria;
import com.example.modules.dept.dao.entity.Dept;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author honor
 */
@Mapper(builder = @Builder())
public interface DeptConvertMapper {
    DeptConvertMapper INSTANT = Mappers.getMapper(DeptConvertMapper.class);

    DeptVO from(Dept user);

    List<DeptVO> convertToVOList(List<Dept> depts);

    DeptCriteria convertToCriteria(Dept dept);

//    UserInfoRep from(DeptInfo userInfo);
//
//    Dept from(DeptReq userReq);

}
