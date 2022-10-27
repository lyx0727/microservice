package com.lyx.user.service;

import com.lyx.feign.pojo.User;
import com.lyx.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User queryById(Long id) {
        return userMapper.findById(id);
    }
}