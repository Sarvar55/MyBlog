package com.example.myblog.service;

import com.example.myblog.model.dto.CommentDto;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);
}
