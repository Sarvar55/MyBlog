package com.example.myblog.controller;

import com.example.myblog.model.dto.PostDto;
import com.example.myblog.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
public interface PostRestService {
    ResponseEntity<PostDto> createPost(PostDto postDto, Integer userId, Integer categoryId);

    ResponseEntity<PostDto> updatePost(PostDto postDto, Integer postId);

    ResponseEntity<ApiResponse> deletePost(Integer postId);

    ResponseEntity<List<PostDto>> getPosts();

    ResponseEntity<PostDto> getPostById(Integer postId);

    ResponseEntity<List<PostDto>> getPostByCategory(Integer categoryId);

    ResponseEntity<List<PostDto>> getPostByUser(Integer userId);

    ResponseEntity<List<PostDto>> searchPosts(String keyword);
}
