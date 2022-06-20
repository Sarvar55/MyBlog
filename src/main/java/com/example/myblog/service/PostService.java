package com.example.myblog.service;

import com.example.myblog.model.dto.PostDto;
import com.example.myblog.response.PostResponse;

import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    PostResponse<PostDto> getPosts(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);

    PostDto getPostById(Integer postId);

    List<PostDto> getPostByCategory(Integer categoryId);

    List<PostDto> getPostByUser(Integer userId);

    List<PostDto> searchPosts(String keyword);
}
