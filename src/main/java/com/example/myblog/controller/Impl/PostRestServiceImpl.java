package com.example.myblog.controller.Impl;

import com.example.myblog.config.AppConstant;
import com.example.myblog.controller.PostRestService;
import com.example.myblog.model.dto.PostDto;
import com.example.myblog.response.ApiResponse;
import com.example.myblog.response.PostResponse;
import com.example.myblog.service.FileService;
import com.example.myblog.service.PostService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@RestController
@RequestMapping("/api")
public class PostRestServiceImpl implements PostRestService {

    private final PostService postService;
    private final FileService fileService;

    @Value("${project.image}")
    private String path;

    public PostRestServiceImpl(PostService postService, FileService fileService) {
        this.postService = postService;
        this.fileService = fileService;
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
    public ResponseEntity<PostResponse<PostDto>> getPosts(@RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
                                                          @RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize,
                                                          @RequestParam(value = "sortBy", defaultValue = AppConstant.SORT_BY, required = false) String sortBy,
                                                          @RequestParam(value = "sortDir", defaultValue = AppConstant.SORT_DIR, required = false) String sortDir) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPosts(pageNumber, pageSize, sortBy, sortDir));
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

    @SneakyThrows
    @Override
    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadPostImage(MultipartFile image, Integer postId) {
        PostDto postDto = this.postService.getPostById(postId);
        String fileName = this.fileService.uploadImage(path, image);
        postDto.setImageName(fileName);
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return ResponseEntity.ok(updatePost);
    }

    @SneakyThrows
    @Override
    @GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable String imageName, HttpServletResponse response) {
        InputStream inputStream = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(inputStream, response.getOutputStream());
    }
}
