package com.example.SmartTravel.Mapper;

import com.example.SmartTravel.DTO.RouteDTO;
import com.example.SmartTravel.Entity.Location;
import com.example.SmartTravel.Entity.Route;
import com.example.SmartTravel.Entity.TransportOption;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    public RouteDTO toDTO(Route route){
        RouteDTO dto = new RouteDTO();
        dto.setId(route.getId());
        dto.setStartLocation(route.getStartLocation().getId());
        dto.setEndLocation(route.getEndLocation().getId());
        dto.setTransportOption(route.getTransportOption().getId());
        dto.setEstimatedTime(route.getEstimatedTime());
        dto.setDistance(route.getDistance());
        dto.setCreatedAt(route.getCratedAt());
        dto.setUpdatedAt(route.getUpdatedAt());
        return dto;
    }

    public Route toEntity(RouteDTO routeDTO, Location startLocation, Location endLocation, TransportOption transportOption){
        Route route = new Route();
        route.setId(routeDTO.getId());
        route.setStartLocation(startLocation);
        route.setEndLocation(endLocation);
        route.setTransportOption(transportOption);
        route.setEstimatedTime(routeDTO.getEstimatedTime());
        route.setDistance(routeDTO.getDistance());
        route.setCratedAt(routeDTO.getCreatedAt());
        route.setUpdatedAt(routeDTO.getUpdatedAt());
        return route;
    }

}
