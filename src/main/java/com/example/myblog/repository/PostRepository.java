package com.example.myblog.repository;

import com.example.myblog.model.entity.Category;
import com.example.myblog.model.entity.Post;
import com.example.myblog.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    @Query("Select post from post post where post.title like %:title%")
    List<Post> searchPost(@Param("title") String title);
}
