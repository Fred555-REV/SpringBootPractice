package com.example.practice.vehicles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v where v.make = :make")
    List<Vehicle> getAllByMake(@Param("make") String make);

    @Query("SELECT v FROM Vehicle v where v.year = :year")
    List<Vehicle> getAllByYear(@Param("year") Integer year);

    List<Vehicle> findAllByModel(String model);
}
