package com.example.practice.stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService service;

    @GetMapping
    public List<Store> getAllStores() {
        return service.getAllStores();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Store> getStoreByID(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.getStoreByID(id), HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public Store getStoreByName(@PathVariable("name") String name) {
        return service.getStoreByName(name);
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return service.createStore(store);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Store> getStoreByID(@PathVariable("id") Long id, @RequestBody Store store) {
        return new ResponseEntity<>(service.updateStoreByID(id, store), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id){
        service.deleteStoreById(id);
    }

}
