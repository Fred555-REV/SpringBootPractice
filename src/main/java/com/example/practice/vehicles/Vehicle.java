package com.example.practice.vehicles;

import com.example.practice.stores.Store;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "store_id",referencedColumnName = "id")
    private Store store;

    public Vehicle() {
    }

    public Vehicle(String make, String model, Integer year, Store store) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Long getId() {
        return id;
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

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
