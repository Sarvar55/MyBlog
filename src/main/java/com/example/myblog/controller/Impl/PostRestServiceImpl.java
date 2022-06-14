package com.example.myblog.controller.Impl;

import com.example.myblog.controller.PostRestService;
import com.example.myblog.model.dto.PostDto;
import com.example.myblog.response.ApiResponse;
import com.example.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@RestController
@RequestMapping("/api")
public class PostRestServiceImpl implements PostRestService {

    private final PostService postService;

    public PostRestServiceImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable("userId")
            Integer userId, @PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postDto, userId, categoryId));
    }

    @Override
    @PutMapping("/user/{userId}/category/{categoryId}/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable("postId") Integer postId) {
        return ResponseEntity.status(HttpStatus.OK).body(postDto);
    }

    @Override
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable("postId") Integer postId) {
        ApiResponse response = new ApiResponse();
        response.setMessage("post deleted Succesfully");
        response.setSuccess(true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPosts());
    }

    @Override
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("postId") Integer postId) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostById(postId));
    }

    @Override
    @GetMapping("/categories/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostByCategory(categoryId));
    }

    @Override
    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable("userId") Integer userId) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostByUser(userId));
    }

    @Override
    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDto>> searchPosts(@PathVariable("keyword") String keyword) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.searchPosts(keyword));
    }
}
