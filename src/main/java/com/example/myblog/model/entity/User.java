package com.example.myblog.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */

@Entity(name = "User")
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @SequenceGenerator(sequenceName = "userSequnce", name = "userSequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "userSequence")
    private Integer userId;

    private String name;

    private String email;

    private String password;

    private String about;
}
