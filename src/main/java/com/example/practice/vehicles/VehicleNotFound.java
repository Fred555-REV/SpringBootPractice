package com.example.practice.vehicles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleNotFound extends RuntimeException {
    public VehicleNotFound(String s) {
        super(s);
    }
}
