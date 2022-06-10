package com.example.myblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resurceName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String resurceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %d", resurceName, fieldName, fieldValue));
        this.resurceName = resurceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
