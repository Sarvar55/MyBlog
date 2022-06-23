package com.example.myblog.controller;

import com.example.myblog.model.dto.PostDto;
import com.example.myblog.response.ApiResponse;
import com.example.myblog.response.PostResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
public interface PostRestService {
    ResponseEntity<PostDto> createPost(PostDto postDto, Integer userId, Integer categoryId);

    ResponseEntity<PostDto> updatePost(PostDto postDto, Integer postId);

    ResponseEntity<ApiResponse> deletePost(Integer postId);

    ResponseEntity<PostResponse<PostDto>> getPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    ResponseEntity<PostDto> getPostById(Integer postId);

    ResponseEntity<List<PostDto>> getPostByCategory(Integer categoryId);

    ResponseEntity<List<PostDto>> getPostByUser(Integer userId);

    ResponseEntity<List<PostDto>> searchPosts(String keyword);

    ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image, @PathVariable Integer postId);

    void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response);
}
