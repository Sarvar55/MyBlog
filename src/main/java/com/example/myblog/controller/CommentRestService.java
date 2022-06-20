package com.example.myblog.controller;

import com.example.myblog.model.dto.CommentDto;
import com.example.myblog.response.ApiResponse;
import org.springframework.http.ResponseEntity;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
public interface CommentRestService {
    ResponseEntity<CommentDto> createComment(CommentDto commentDto, Integer postId);

    ResponseEntity<ApiResponse> deleteComment(Integer commentId);
}
