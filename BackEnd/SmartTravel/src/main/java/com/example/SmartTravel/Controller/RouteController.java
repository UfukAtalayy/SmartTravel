package com.example.SmartTravel.Controller;

import com.example.SmartTravel.DTO.RouteDTO;
import com.example.SmartTravel.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<RouteDTO> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public RouteDTO getRouteById(@PathVariable Long id){
        return routeService.getRouteById(id);
    }

    @PostMapping
    public RouteDTO createRoute(@RequestBody RouteDTO routeDTO){
        return routeService.createRoute(routeDTO);
    }

    @PutMapping("/{id}")
    public RouteDTO updateRoute(@PathVariable Long id, @RequestBody RouteDTO routeDTO){
        return routeService.updateRoute(id, routeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Long id){
        routeService.deleteRoute(id);
    }
}
