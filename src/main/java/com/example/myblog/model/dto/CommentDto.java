package com.example.myblog.model.dto;

import com.example.myblog.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Integer commentId;

    private String content;

    private Post post;
}
