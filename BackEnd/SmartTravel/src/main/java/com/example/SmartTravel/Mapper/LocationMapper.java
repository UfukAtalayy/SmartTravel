package com.example.SmartTravel.Mapper;

import com.example.SmartTravel.DTO.LocationDTO;
import com.example.SmartTravel.Entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationDTO toDTO(Location location){
        LocationDTO dto = new LocationDTO();
        dto.setId(location.getId());
        dto.setName(location.getName());
        dto.setLatitude(location.getLatitude());
        dto.setLongitude(location.getLongitude());
        dto.setCreatedAt(location.getCreatedAt());
        dto.setUpdatedAt(location.getUpdatedAt());
        return dto;
    }

    public Location toEntity(LocationDTO locationDTO){
        Location location = new Location();
        location.setId(locationDTO.getId());
        location.setName(locationDTO.getName());
        location.setLatitude(locationDTO.getLatitude());
        location.setLongitude(locationDTO.getLongitude());
        location.setCreatedAt(locationDTO.getCreatedAt());
        location.setUpdatedAt(locationDTO.getUpdatedAt());
        return location;
    }
}
