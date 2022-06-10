package com.example.myblog.controller;

import com.example.myblog.model.dto.UserDto;
import com.example.myblog.model.entity.User;
import com.example.myblog.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
public interface UserController {
    ResponseEntity<UserDto> findByUserId(Integer userId);

    ResponseEntity<ApiResponse> userDelete(Integer userId);

    ResponseEntity<UserDto> createUser(UserDto user);

    ResponseEntity<List<UserDto>> getAllUser();

    ResponseEntity<UserDto> updateUser(UserDto userDto, Integer userId);
}
