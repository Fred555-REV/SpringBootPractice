package com.example.practice.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> getVehicles() {
        return repository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return repository.findById(id).isPresent() ? repository.getById(id) : null;
    }

    public List<Vehicle> getVehiclesByMake(String make) {
        if (make.equals("none")) {
            return repository.findAll(Sort.by("make"));
        }
        List<Vehicle> output = new ArrayList<>();
        for (Vehicle vehicle : repository.findAll()) {
            if (vehicle.getMake().toLowerCase(Locale.ROOT).equals(make.toLowerCase(Locale.ROOT))) {
                output.add(vehicle);
            }
        }
        return output;
    }

    public List<Vehicle> getVehiclesByYear(Integer year) {
        List<Vehicle> output = new ArrayList<>();
        for (Vehicle vehicle : repository.findAll()) {
            if (vehicle.getYear().equals(year)) {
                output.add(vehicle);
            }
        }
        return output;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        repository.save(vehicle);
        return vehicle;
    }

    public boolean destroyVehicle(Long Id) {
        if (repository.findById(Id).isPresent()) {
            repository.deleteById(Id);
            return true;
        }
        return false;
    }

    public Vehicle updateVehicle(Vehicle newVehicle, Long id) {
        return repository.findById(id).map(vehicle -> {

            if (!(newVehicle.getMake() == null))
                vehicle.setMake(newVehicle.getMake());
            if (!(newVehicle.getModel() == null))
                vehicle.setModel(newVehicle.getModel());
            if (!(newVehicle.getYear() == null))
                vehicle.setYear(newVehicle.getYear());
            return repository.save(vehicle);
        }).orElseGet(() -> repository.save(newVehicle));
    }
}
