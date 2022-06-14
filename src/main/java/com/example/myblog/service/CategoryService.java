package com.example.myblog.service;

import com.example.myblog.model.dto.CategoryDto;

import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    void deleteCategory(Integer categoryId);

    CategoryDto getCategory(Integer categoryId);

    List<CategoryDto> getCategories();

}
