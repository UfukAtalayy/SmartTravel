package com.example.SmartTravel.Mapper;

import com.example.SmartTravel.DTO.TrafficInfoDTO;
import com.example.SmartTravel.Entity.Location;
import com.example.SmartTravel.Entity.TrafficInfo;
import org.springframework.stereotype.Component;

@Component
public class TrafficInfoMapper {

    public TrafficInfoDTO toDTO(TrafficInfo trafficInfo){
        TrafficInfoDTO dto = new TrafficInfoDTO();
        dto.setId(trafficInfo.getId());
        dto.setLocation(trafficInfo.getLocation().getId());
        dto.setTrafficLevel(trafficInfo.getTrafficLevel());
        dto.setUpdatedAt(trafficInfo.getUpdatedAt());
        return dto;
    }

    public TrafficInfo toEntity(TrafficInfoDTO trafficInfoDTO, Location location){
        TrafficInfo trafficInfo = new TrafficInfo();
        trafficInfo.setId(trafficInfoDTO.getId());
        trafficInfo.setLocation(location);
        trafficInfo.setTrafficLevel(trafficInfoDTO.getTrafficLevel());
        trafficInfo.setUpdatedAt(trafficInfoDTO.getUpdatedAt());
        return trafficInfo;
    }
}
