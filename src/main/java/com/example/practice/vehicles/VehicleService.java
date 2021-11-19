package com.example.practice.vehicles;

import com.example.practice.customers.CustomerNotFound;
import com.example.practice.locations.Location;
import com.example.practice.locations.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repository;

    @Autowired
    private LocationRepository locationRepository;

    public List<Vehicle> getVehicles() {
        return repository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
//        return repository.findById(id).isPresent() ? repository.getById(id) : null;
        return repository.findById(id).orElseThrow(VehicleNotFound::new);
    }

    public ResponseEntity<List<Vehicle>> getVehiclesByMake(String make) {
        return new ResponseEntity<>(repository.getAllByMake(make), HttpStatus.OK);
    }

    public ResponseEntity<List<Vehicle>> getVehiclesByYear(Integer year) {
        return new ResponseEntity<>(repository.getAllByYear(year), HttpStatus.OK);
    }

    public List<Vehicle> getVehiclesByModel(String model) {
        return repository.findAllByModel(model);
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        repository.save(vehicle);
        return vehicle;
    }

    public Vehicle addLocation(Vehicle update) {
        Vehicle vehicle = repository.findById(update.getId()).orElseThrow(VehicleNotFound::new);
        if (vehicle.getLocation() != null) {
            Location location = vehicle.getLocation();
            location.setAddress(update.getLocation().getAddress());
            locationRepository.save(location);
            return vehicle;
        }
        vehicle.setLocation(update.getLocation());
        return repository.save(vehicle);
    }

    public void deleteLocation(Long id) {
        repository.findById(id).map(vehicle -> {
            locationRepository.delete(vehicle.getLocation());
            vehicle.setLocation(null);
            return repository.save(vehicle);
        }).orElseThrow(VehicleNotFound::new);
    }

    public void destroyVehicle(Long id) {
        if (repository.findById(id).isEmpty())
            throw new VehicleNotFound("Vehicle to delete Not Found");
        repository.deleteById(id);
    }

    public Vehicle updateVehicle(Vehicle newVehicle, Long id) {
        return repository.findById(id).map(vehicle -> {
            if (!(newVehicle.getMake() == null)) vehicle.setMake(newVehicle.getMake());
            if (!(newVehicle.getModel() == null)) vehicle.setModel(newVehicle.getModel());
            if (!(newVehicle.getYear() == null)) vehicle.setYear(newVehicle.getYear());
            return repository.save(vehicle);
        }).orElseThrow(VehicleNotFound::new);
    }

    public List<Vehicle> getVehiclesByStoreID(Long id) {
        return repository.findAllByStoreId(id);
    }
}
