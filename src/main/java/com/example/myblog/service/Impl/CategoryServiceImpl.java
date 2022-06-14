package com.example.myblog.service.Impl;

import com.example.myblog.exception.ResourceNotFoundException;
import com.example.myblog.model.dto.CategoryDto;
import com.example.myblog.model.entity.Category;
import com.example.myblog.repository.CategoryRepository;
import com.example.myblog.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final ModelMapper modelMapper;

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        categoryRepository.save(category);

        CategoryDto savedCategoryDto = modelMapper.map(category, CategoryDto.class);
        return savedCategoryDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "categoryId", categoryId)
        );

        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(category.getCategoryDescription());

        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "categoryId", categoryId)
        );
        categoryRepository.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "categoryId", categoryId)
        );

        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
