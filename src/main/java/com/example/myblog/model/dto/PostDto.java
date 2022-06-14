package com.example.myblog.model.dto;

import com.example.myblog.model.entity.Category;
import com.example.myblog.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Integer postId;

    private String title;

    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;
}
