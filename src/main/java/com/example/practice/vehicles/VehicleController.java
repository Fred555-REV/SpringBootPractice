package com.example.practice.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @GetMapping
    public List<Vehicle> getVehicles() {
        return service.getVehicles();
    }

    @GetMapping("/sort/{year}")
    @ResponseBody
    public ResponseEntity<List<Vehicle>> getVehiclesByYear(@PathVariable Integer year) {
        return service.getVehiclesByYear(year);
    }

    @GetMapping("/search/{model}")
    @ResponseBody
    public List<Vehicle> getVehiclesByModel(@PathVariable(name = "model") String model) {
        return service.getVehiclesByModel(model);
    }

    @GetMapping("/store/{store_id}")
    public List<Vehicle> getVehiclesByStoreID(@PathVariable("store_id") Long id) {
        return service.getVehiclesByStoreID(id);
    }


    @GetMapping("/sort")
    @ResponseBody
    public ResponseEntity<List<Vehicle>> getVehiclesByMake(@RequestParam(name = "make", defaultValue = "none") String make) {
        return service.getVehiclesByMake(make);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable(name = "id") Long id) {
        return service.getVehicleById(id);
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return service.addVehicle(vehicle);
    }

    @PostMapping("/location")
    public Vehicle addLocation(@RequestBody Vehicle update) {
        return service.addLocation(update);
    }

    @DeleteMapping("/location/{id}")
    public void deleteLocation(@PathVariable Long id){
        service.deleteLocation(id);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable(name = "id") Long id) {
        return service.updateVehicle(vehicle, id);
    }

    @DeleteMapping("/{id}")
    public void destroyVehicleById(@PathVariable Long id) {
        service.destroyVehicle(id);
    }

}
