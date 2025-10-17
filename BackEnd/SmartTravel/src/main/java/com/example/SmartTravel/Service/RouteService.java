package com.example.SmartTravel.Service;

import com.example.SmartTravel.DTO.RouteDTO;
import com.example.SmartTravel.Entity.Location;
import com.example.SmartTravel.Entity.Route;
import com.example.SmartTravel.Entity.TransportOption;
import com.example.SmartTravel.Mapper.RouteMapper;
import com.example.SmartTravel.Repository.LocationRepository;
import com.example.SmartTravel.Repository.RouteRepository;
import com.example.SmartTravel.Repository.TransportOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TransportOptionRepository transportOptionRepository;

    public List<RouteDTO> getAllRoutes(){
        return routeRepository.findAll()
                .stream()
                .map(routeMapper::toDTO)
                .collect(Collectors.toList());
    }
    public RouteDTO getRouteById(Long id){
        Route route = routeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Route not found with id:"+id));
        return routeMapper.toDTO(route);
    }

    public void deleteRoute(Long id){
        routeRepository.deleteById(id);
    }

    public RouteDTO createRoute(RouteDTO routeDTO){
        Location startLocation = null;
        if (routeDTO.getStartLocation() != null){
            startLocation = locationRepository.findById(routeDTO.getStartLocation())
                    .orElseThrow(()->new RuntimeException("Start location not found"));
        }

        Location endLocation = null;
        if (routeDTO.getEndLocation() != null){
            endLocation = locationRepository.findById(routeDTO.getEndLocation())
                    .orElseThrow(()->new RuntimeException("End location not found"));
        }

        TransportOption transportOption = transportOptionRepository.findById(routeDTO.getTransportOption())
                .orElseThrow(()->new RuntimeException("Transport option not found"));
        Route route = routeMapper.toEntity(routeDTO,startLocation,endLocation,transportOption);
        return routeMapper.toDTO(routeRepository.save(route));
    }

    public RouteDTO updateRoute(Long id,RouteDTO routeDTO){
        Route route = routeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Route not found"));
        route.setEstimatedTime(routeDTO.getEstimatedTime());
        route.setDistance(routeDTO.getDistance());
        route.setCratedAt(routeDTO.getCreatedAt());
        route.setUpdatedAt(routeDTO.getUpdatedAt());

        Location startLocation = locationRepository.findById(routeDTO.getStartLocation())
                .orElseThrow(()->new RuntimeException("Start location not found"));
        route.setStartLocation(startLocation);

        Location endLocation = locationRepository.findById(routeDTO.getEndLocation())
                .orElseThrow(()->new RuntimeException("End location not found"));
        route.setEndLocation(endLocation);

        TransportOption transportOption = transportOptionRepository.findById(routeDTO.getTransportOption())
                .orElseThrow(()->new RuntimeException("Transport option not found"));
        route.setTransportOption(transportOption);
        return routeMapper.toDTO(routeRepository.save(route));
    }

}
