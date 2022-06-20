package com.example.myblog.controller.Impl;

import com.example.myblog.controller.CommentRestService;
import com.example.myblog.model.dto.CommentDto;
import com.example.myblog.response.ApiResponse;
import com.example.myblog.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@RestController
@RequestMapping("/api/comments")
public class CommentRestServiceImpl implements CommentRestService {
    private final CommentService commentService;

    public CommentRestServiceImpl(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable("postId") Integer postId) {
        return ResponseEntity.ok(commentService.createComment(commentDto, postId));
    }

    @Override
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable("commentId") Integer commentId) {
        return ResponseEntity.ok(new ApiResponse("Comment deleted succesfully", true));
    }
}
