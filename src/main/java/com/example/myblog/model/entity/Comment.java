package com.example.myblog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Data
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comment")
public class Comment {
    @Id
    @SequenceGenerator(name = "commentSequence", sequenceName = "commentSequence", initialValue = 10, allocationSize = 1)
    @GeneratedValue(generator = "commentSequence")
    private Integer commentId;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
//neden boyle yazdik yazmasak da olur biz yazmasak gidip post entitisindek postId sini alip tabloya oyle yazacak
    private Post post;
}
