package com.example.practice.stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    public List<Store> getAllStores() {
        return repository.findAll();
    }

    public Store getStoreByID(Long id) {
        if(!repository.existsById(id))
            throw new StoreNotFound();
        return repository.getById(id);
    }

    public Store createStore(Store store) {
        repository.save(store);
        return store;
    }
}
