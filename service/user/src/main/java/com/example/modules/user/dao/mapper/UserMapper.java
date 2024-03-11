package com.example.modules.user.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.modules.user.dao.entity.User;

/**
 * @author honor
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     *
     * @return
     */
    User selectByTenantId();

}
