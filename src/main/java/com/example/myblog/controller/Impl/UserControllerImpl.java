package com.example.myblog.controller.Impl;

import com.example.myblog.controller.UserController;
import com.example.myblog.model.dto.UserDto;
import com.example.myblog.model.entity.User;
import com.example.myblog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findByUserId(@PathVariable Integer userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.findByUserId(userId));
    }

    @Override
    @DeleteMapping("/{userId}")
    public ResponseEntity<Map<String, Boolean>> userDelete(@PathVariable Integer userId) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("User deleted succesfully", true);
        userService.userDelete(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(this.userService.createUser(userDto));
    }

    @Override
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok(this.userService.getAllUser());
    }

    @Override
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
        return ResponseEntity.ok(this.userService.updateUser(userDto, userId));
    }
}
