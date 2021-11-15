package com.example.practice.stores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StoreNotFound extends RuntimeException{
    public StoreNotFound() {
        super("Store Not Found");
    }

    public StoreNotFound(String message) {
        super(message);
    }

}
