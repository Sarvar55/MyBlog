package com.example.myblog.service.Impl;

import com.example.myblog.exception.ResourceNotFoundException;
import com.example.myblog.model.dto.CommentDto;
import com.example.myblog.model.entity.Comment;
import com.example.myblog.model.entity.Post;
import com.example.myblog.repository.CommentRepository;
import com.example.myblog.repository.PostRepository;
import com.example.myblog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "postId", postId)
        );
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setPost(post);

        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Comment", "commentId", commentId)
                );
        commentRepository.delete(comment);
    }
}
