package com.example.practice.vehicles;

import javax.persistence.Entity;

public class Vehicle {
    private Long vin;
    private String make;
    private String model;
    private Integer year;

    public Vehicle() {
    }

    public Vehicle(String make, String model, Integer year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Vehicle(Long vin, String make, String model, Integer year) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Long getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }
}
