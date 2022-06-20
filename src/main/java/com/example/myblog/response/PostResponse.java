package com.example.myblog.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse<T> {
    private List<T> content;
    private long totalElements;
    private int pageSize;
    private int pageNumber;
    private boolean isLast;
    private int totalPages;
}
