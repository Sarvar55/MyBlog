package com.example.myblog.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty(message = "Title cannot be empty")
    @JsonAlias({"categoryTitle"})
    private String categoryTitle;

    @NotEmpty(message = "Description can not be empty")
    private String categoryDescription;
}
