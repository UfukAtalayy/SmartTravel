package com.example.SmartTravel.Mapper;

import com.example.SmartTravel.DTO.TransportOptionDTO;
import com.example.SmartTravel.Entity.TransportOption;
import org.springframework.stereotype.Component;

@Component
public class TransportOptionMapper {

    public TransportOptionDTO toDTO(TransportOption transportOption){
        TransportOptionDTO dto = new TransportOptionDTO();
        dto.setId(transportOption.getId());
        dto.setName(transportOption.getName());
        dto.setAverageSpeed(transportOption.getAverageSpeed());
        dto.setCreatedAt(transportOption.getCreatedAt());
        dto.setUpdatedAt(transportOption.getUpdatedAt());
        return dto;
    }

    public TransportOption toEntity(TransportOptionDTO transportOptionDTO){
        TransportOption transportOption = new TransportOption();
        transportOption.setId(transportOptionDTO.getId());
        transportOption.setName(transportOptionDTO.getName());
        transportOption.setAverageSpeed(transportOptionDTO.getAverageSpeed());
        transportOption.setCreatedAt(transportOptionDTO.getCreatedAt());
        transportOption.setUpdatedAt(transportOptionDTO.getUpdatedAt());
        return transportOption;
    }
}
