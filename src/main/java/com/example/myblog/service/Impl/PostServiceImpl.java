package com.example.myblog.service.Impl;

import com.example.myblog.exception.ResourceNotFoundException;
import com.example.myblog.model.dto.PostDto;
import com.example.myblog.model.entity.Category;
import com.example.myblog.model.entity.Post;
import com.example.myblog.model.entity.User;
import com.example.myblog.repository.CategoryRepository;
import com.example.myblog.repository.PostRepository;
import com.example.myblog.repository.UserRepository;
import com.example.myblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "userId", userId)
        );

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Category", "categorId", categoryId)
                );
        Post post = modelMapper.map(postDto, Post.class);
        post.setCategory(category);
        post.setUser(user);
        post.setAddedDate(new Date());
        post.setImageName("image.png");

        return modelMapper.map(postRepository.save(post), PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "postId", postId)
        );
        post.setAddedDate(new Date());
        post.setContent(postDto.getContent());
        post.setTitle(post.getTitle());

        return modelMapper.map(postRepository.save(post), PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post", "postId", postId)
                );
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post", "postId", postId)
                );

        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "categorId", categoryId)
        );

        List<PostDto> postDtos = postRepository
                .findByCategory(category).stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "userId", userId)
        );

        return postRepository.findByUser(user).stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return postRepository.searchPost(keyword)
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }
}
