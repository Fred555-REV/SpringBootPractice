package com.example.practice.customers;

import com.example.practice.stores.Store;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer wallet;
    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "store_customer",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id")
    )
    private Set<Store> stores;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer wallet, Set<Store> stores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = wallet;
        this.stores = stores;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
