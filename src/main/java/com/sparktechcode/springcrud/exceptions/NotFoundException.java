package com.sparktechcode.springcrud.exceptions;


import com.sparktechcode.springjpasearch.exceptions.BaseSparkException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseSparkException {

    private static final HttpStatus DEFAULT_STATUS = HttpStatus.NOT_FOUND;

    public NotFoundException() {
        super(DEFAULT_STATUS, SparkCrudError.RESOURCE_NOT_FOUND, "Resource not found");
    }

    public NotFoundException(String message) {
        super(DEFAULT_STATUS, SparkCrudError.RESOURCE_NOT_FOUND, message);
    }

    public NotFoundException(Object error, String message) {
        super(DEFAULT_STATUS, error, message);
    }

    public NotFoundException(Object error, String message, Object data) {
        super(DEFAULT_STATUS, error, message);
        setData(data);
    }
}
