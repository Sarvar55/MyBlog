package com.example.myblog.repository;

import com.example.myblog.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
public interface RoleRepositories extends JpaRepository<Role, Integer> {
}
