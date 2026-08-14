package com.spms.parking_space_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpaceDTO {
    private Long id;
    private String location;
    private String status;
    private Long ownerId;
}
