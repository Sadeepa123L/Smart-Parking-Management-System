package com.spms.vehicle_service.repository;

import com.spms.vehicle_service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByLicensePlate(String licensePlate);
    List<Vehicle> findByUserId(Long userId);
}
