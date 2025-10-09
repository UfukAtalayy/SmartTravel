package com.example.SmartTravel.Controller;

import com.example.SmartTravel.DTO.LocationDTO;
import com.example.SmartTravel.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<LocationDTO> getAllLocations(){
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public LocationDTO getLocationById(@PathVariable Long id){
        return locationService.getLocationById(id);
    }

    @PostMapping
    public LocationDTO createLocation(@RequestBody LocationDTO locationDTO){
        return locationService.createLocation(locationDTO);
    }

    @PutMapping("/{id}")
    public LocationDTO updateLocation(@PathVariable Long id,@RequestBody LocationDTO locationDTO){
        return locationService.updateLocation(id, locationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id){
        locationService.deleteLocation(id);
    }
}
