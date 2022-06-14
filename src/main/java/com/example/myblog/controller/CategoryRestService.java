package com.example.myblog.controller;

import com.example.myblog.model.dto.CategoryDto;
import com.example.myblog.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
public interface CategoryRestService {
    ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto);

    ResponseEntity<CategoryDto> updateCategory(CategoryDto categoryDto, Integer categoryId);

    ResponseEntity<ApiResponse> deleteCategory(Integer categoryId);

    ResponseEntity<List<CategoryDto>> getCategories();

    ResponseEntity<CategoryDto> getSingleCategory(Integer categoryId);
}
