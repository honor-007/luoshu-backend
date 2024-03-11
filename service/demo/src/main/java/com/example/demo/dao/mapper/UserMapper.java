package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.dao.entity.User;

import java.util.List;

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
