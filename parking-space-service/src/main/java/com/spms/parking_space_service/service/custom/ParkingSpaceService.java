package com.spms.parking_space_service.service.custom;

import com.spms.parking_space_service.dto.ParkingSpaceDTO;

import java.util.List;

public interface ParkingSpaceService {
    ParkingSpaceDTO addParkingSpace(ParkingSpaceDTO parkingSpaceDTO);
    List<ParkingSpaceDTO> getAllParkingSpaces();
    List<ParkingSpaceDTO> getParkingSpacesByLocationAndStatus(String location, String status);
    ParkingSpaceDTO reserveSpace(Long id);
    ParkingSpaceDTO releaseSpace(Long id);
    ParkingSpaceDTO updateSpaceStatus(Long id, String status);
}
