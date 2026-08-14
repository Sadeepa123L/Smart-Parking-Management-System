package com.spms.vehicle_service.service.custom;

import com.spms.vehicle_service.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO registerVehicle(VehicleDTO vehicleDTO);
    VehicleDTO updateVehicle(Long id, VehicleDTO vehicleDTO);
    VehicleDTO getVehicle(Long id);
    List<VehicleDTO> getVehiclesByUserId(Long userId);
    List<VehicleDTO> getAllVehicles();
    VehicleDTO updateVehicleStatus(Long id, String status);
}
