package com.sagar.resume.exception;

public class ResourceExistsException extends RuntimeException{

    public ResourceExistsException(String message)
    {
        super(message);
    }
}
