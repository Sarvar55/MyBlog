package com.example.myblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;

    @NotEmpty
    @Size(min = 5, message = "username must be of 5 characters")
    private String name;

    @Email(message = "Email adress is not valid")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 3, max = 10, message = "Password must be min of 3 characters and max of 10 characters !!")
    private String password;

    @NotEmpty(message = "about cannot be empty")
    private String about;


}
