package com.example.SmartTravel.Service;

import com.example.SmartTravel.DTO.LocationDTO;
import com.example.SmartTravel.Entity.Location;
import com.example.SmartTravel.Mapper.LocationMapper;
import com.example.SmartTravel.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper locationMapper;

    public List<LocationDTO> getAllLocations(){
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LocationDTO getLocationById(Long id){
        Location location = locationRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Location not found with id:"+id));
        return locationMapper.toDTO(location);
    }

    public LocationDTO createLocation(LocationDTO locationDTO){
        Location location = locationMapper.toEntity(locationDTO);
        return locationMapper.toDTO(locationRepository.save(location));
    }

    public void deleteLocation(Long id){
        locationRepository.deleteById(id);
    }

    public LocationDTO updateLocation(Long id, LocationDTO locationDTO){
        Location location = locationRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Location not found"));
        location.setName(locationDTO.getName());
        location.setLatitude(locationDTO.getLatitude());
        location.setLongitude(locationDTO.getLongitude());
        location.setCreatedAt(locationDTO.getCreatedAt());
        location.setUpdatedAt(locationDTO.getUpdatedAt());
        return locationMapper.toDTO(locationRepository.save(location));
    }
}
