package com.example.myblog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Entity(name = "post")
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @SequenceGenerator(name = "postSequence", sequenceName = "postSequence", initialValue = 10, allocationSize = 1)
    @GeneratedValue(generator = "postSequence")
    private Integer postId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String imageName;

    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments;

}
