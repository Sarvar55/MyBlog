package com.example.myblog.controller.Impl;

import com.example.myblog.controller.CategoryRestService;
import com.example.myblog.model.dto.CategoryDto;
import com.example.myblog.response.ApiResponse;
import com.example.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryRestServiceImpl implements CategoryRestService {

    private final CategoryService service;

    public CategoryRestServiceImpl(CategoryService service) {
        this.service = service;
    }


    @Override
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CategoryDto categoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCategory(categoryDto));
    }

    @Override
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody @Valid CategoryDto categoryDto,
                                                      @PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
    }

    @Override
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        ApiResponse response = new ApiResponse();
        response.setMessage("category deleted Succesfully");
        response.setSuccess(true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.ok(service.getCategories());
    }

    @Override
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.ok(service.getCategory(categoryId));
    }
}
