package com.example.myblog.repository;

import com.example.myblog.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
