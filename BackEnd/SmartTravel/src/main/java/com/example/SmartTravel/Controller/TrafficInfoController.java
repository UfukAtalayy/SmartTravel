package com.example.SmartTravel.Controller;

import com.example.SmartTravel.DTO.TrafficInfoDTO;
import com.example.SmartTravel.Service.TrafficInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trafficinfo")
public class TrafficInfoController {

    @Autowired
    private TrafficInfoService trafficInfoService;

    @GetMapping
    public List<TrafficInfoDTO> getAllTrafficInfo(){
        return trafficInfoService.getAllTrafficInfo();
    }

    @GetMapping("/{id}")
    public TrafficInfoDTO getTrafficInfoById(@PathVariable Long id){
        return trafficInfoService.getTrafficInfoById(id);
    }

    @PostMapping
    public TrafficInfoDTO createTrafficInfo(@RequestBody TrafficInfoDTO trafficInfoDTO){
        return trafficInfoService.createTrafficInfo(trafficInfoDTO);
    }

    @PutMapping("/{id}")
    public TrafficInfoDTO updateTrafficInfo(@PathVariable Long id,@RequestBody TrafficInfoDTO trafficInfoDTO){
        return trafficInfoService.updateTrafficInfo(id, trafficInfoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTrafficInfo(@PathVariable Long id){
        trafficInfoService.deleteTrafficInfo(id);
    }
}
