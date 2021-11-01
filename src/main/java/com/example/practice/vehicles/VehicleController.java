package com.example.practice.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping("/sort/{year}")
    public List<Vehicle> getVehiclesByYear(@PathVariable Integer year) {
        return vehicleService.getVehiclesByYear(year);
    }

    @GetMapping("/sort")
    public List<Vehicle> getVehiclesByMake(@RequestParam(name = "make",defaultValue = "none") String make) {
        return vehicleService.getVehiclesByMake(make);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable(name = "id") Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle == null) {
            throw new VehicleNotFound("Vehicle not found with given vin");
        }
        return vehicle;
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void destroyVehicleById(@PathVariable Long id) {
        if (!vehicleService.destroyVehicle(id)) {
            throw new VehicleNotFound("Vehicle with given vin not found");
        }
    }

}
