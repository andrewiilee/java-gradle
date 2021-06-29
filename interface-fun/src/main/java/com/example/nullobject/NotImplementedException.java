package com.example.nullobject;

public class NotImplementedException extends RuntimeException {

    public NotImplementedException(String message) {
        super(message + " has not been implemented");
    }
}
