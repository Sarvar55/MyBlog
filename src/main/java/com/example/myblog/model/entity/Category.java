package com.example.myblog.model.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Table(name = "category")
@Entity(name = "category")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Category {
    @Id
    @SequenceGenerator(name = "categorySequence", sequenceName = "categorySequence", initialValue = 10, allocationSize = 1)
    @GeneratedValue(generator = "categorySequnce")
    private Integer categoryId;

    @JsonAlias({"categoryTitle"})
    private String categoryTitle;

    private String categoryDescription;
}
