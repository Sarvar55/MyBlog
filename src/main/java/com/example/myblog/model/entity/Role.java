package com.example.myblog.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Data
@Entity
public class Role {
    @Id
    @SequenceGenerator(sequenceName = "roleSequnce", name = "roleSequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "roleSequence")
    private Integer roleId;

    private String name;

}
