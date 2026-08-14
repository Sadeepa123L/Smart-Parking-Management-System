package com.spms.parking_space_service.controller;

import com.spms.parking_space_service.dto.ParkingSpaceDTO;
import com.spms.parking_space_service.service.custom.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking-spaces")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @PostMapping("/add")
    public ResponseEntity<ParkingSpaceDTO> addParkingSpace(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        return new ResponseEntity<>(parkingSpaceService.addParkingSpace(parkingSpaceDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ParkingSpaceDTO>> getAllParkingSpaces() {
        return ResponseEntity.ok(parkingSpaceService.getAllParkingSpaces());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ParkingSpaceDTO>> searchSpaces(@RequestParam String location,
            @RequestParam String status) {
        return ResponseEntity.ok(parkingSpaceService.getParkingSpacesByLocationAndStatus(location, status));
    }

    @PatchMapping("/{id}/reserve")
    public ResponseEntity<ParkingSpaceDTO> reserveSpace(@PathVariable Long id) {
        return ResponseEntity.ok(parkingSpaceService.reserveSpace(id));
    }

    @PatchMapping("/{id}/release")
    public ResponseEntity<ParkingSpaceDTO> releaseSpace(@PathVariable Long id) {
        return ResponseEntity.ok(parkingSpaceService.releaseSpace(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ParkingSpaceDTO> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(parkingSpaceService.updateSpaceStatus(id, status));
    }
}
