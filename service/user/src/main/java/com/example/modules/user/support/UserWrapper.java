package com.example.modules.user.support;

import com.example.core.mybatis.support.BaseEntityWrapper;
import com.example.core.tool.context.ApplicationContextHolder;
import com.example.modules.dept.feign.IDeptClient;
import com.example.modules.user.controller.vo.UserVO;
import com.example.modules.user.dao.entity.User;
import com.example.modules.user.service.impl.UserService;

import java.util.List;

import static com.example.modules.user.support.UserConvertMapper.INSTANT;

/**
 * @Author honor
 * @Data 2024/6/14 9:51
 * @Version 1.0
 */
public class UserWrapper extends BaseEntityWrapper<User, UserVO> {

    private static UserService userService;
    private static IDeptClient deptClient;

    static {
        userService = ApplicationContextHolder.getContext().getBean(UserService.class);
        deptClient = ApplicationContextHolder.getContext().getBean(IDeptClient.class);
    }


    public static UserWrapper build() {
        return new UserWrapper();
    }

    @Override
    public UserVO entityVO(User entity) {
        UserVO userVO = INSTANT.from(entity);
        List<String> deptNames = deptClient.getDeptNames(entity.getDeptId()).getData();
        userVO.setDeptNames(deptNames);
        return userVO;
    }
}
