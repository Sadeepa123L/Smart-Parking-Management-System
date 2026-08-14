package com.spms.parking_space_service.repository;

import com.spms.parking_space_service.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    List<ParkingSpace> findByLocationAndStatus(String location, String status);
}
