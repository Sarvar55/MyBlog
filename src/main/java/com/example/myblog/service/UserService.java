package com.example.myblog.service;

import com.example.myblog.model.dto.UserDto;
import com.example.myblog.model.entity.User;

import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
public interface UserService {

    UserDto findByUserId(Integer userId);

    void userDelete(Integer userId);

    UserDto createUser(UserDto user);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto user, Integer userId);

}
