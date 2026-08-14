package com.spms.parking_space_service.service.impl;

import com.spms.parking_space_service.dto.ParkingSpaceDTO;
import com.spms.parking_space_service.entity.ParkingSpace;
import com.spms.parking_space_service.repository.ParkingSpaceRepository;
import com.spms.parking_space_service.service.custom.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public ParkingSpaceDTO addParkingSpace(ParkingSpaceDTO parkingSpaceDTO) {
        ParkingSpace space = mapToEntity(parkingSpaceDTO);
        ParkingSpace savedSpace = parkingSpaceRepository.save(space);
        return mapToDTO(savedSpace);
    }

    @Override
    public List<ParkingSpaceDTO> getAllParkingSpaces() {
        return parkingSpaceRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkingSpaceDTO> getParkingSpacesByLocationAndStatus(String location, String status) {
        return parkingSpaceRepository.findByLocationAndStatus(location, status).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParkingSpaceDTO reserveSpace(Long id) {
        ParkingSpace space = parkingSpaceRepository.findById(id).orElseThrow(() -> new RuntimeException("Space not found"));
        space.setStatus("RESERVED");
        return mapToDTO(parkingSpaceRepository.save(space));
    }

    @Override
    public ParkingSpaceDTO releaseSpace(Long id) {
        ParkingSpace space = parkingSpaceRepository.findById(id).orElseThrow(() -> new RuntimeException("Space not found"));
        space.setStatus("AVAILABLE");
        return mapToDTO(parkingSpaceRepository.save(space));
    }

    @Override
    public ParkingSpaceDTO updateSpaceStatus(Long id, String status) {
        ParkingSpace space = parkingSpaceRepository.findById(id).orElseThrow(() -> new RuntimeException("Space not found"));
        space.setStatus(status);
        return mapToDTO(parkingSpaceRepository.save(space));
    }

    private ParkingSpaceDTO mapToDTO(ParkingSpace space) {
        ParkingSpaceDTO dto = new ParkingSpaceDTO();
        dto.setId(space.getId());
        dto.setLocation(space.getLocation());
        dto.setStatus(space.getStatus());
        dto.setOwnerId(space.getOwnerId());
        return dto;
    }

    private ParkingSpace mapToEntity(ParkingSpaceDTO dto) {
        ParkingSpace space = new ParkingSpace();
        space.setId(dto.getId());
        space.setLocation(dto.getLocation());
        space.setStatus(dto.getStatus());
        space.setOwnerId(dto.getOwnerId());
        return space;
    }
}
