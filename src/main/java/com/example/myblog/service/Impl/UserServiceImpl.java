package com.example.myblog.service.Impl;

import com.example.myblog.model.dto.UserDto;
import com.example.myblog.model.entity.User;
import com.example.myblog.repository.UserRepository;
import com.example.myblog.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto findByUserId(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("user not found")
        );
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public void userDelete(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("user not found")
        );
        userRepository.delete(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User updatedUser = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("user not found ")
        );

        updatedUser.setAbout(userDto.getAbout());
        updatedUser.setEmail(userDto.getEmail());
        updatedUser.setName(userDto.getName());
        updatedUser.setPassword(userDto.getPassword());
        userRepository.save(updatedUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }
}
