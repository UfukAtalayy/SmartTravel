package com.example.SmartTravel.Mapper;

import com.example.SmartTravel.DTO.JourneyDTO;
import com.example.SmartTravel.Entity.Journey;
import com.example.SmartTravel.Entity.Location;
import com.example.SmartTravel.Entity.TransportOption;
import com.example.SmartTravel.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class JourneyMapper {

    public JourneyDTO toDTO(Journey journey){
        JourneyDTO dto = new JourneyDTO();
        dto.setId(journey.getId());
        dto.setUser(journey.getUser().getId());
        dto.setStartLocation(journey.getStartLocation().getId());
        dto.setEndLocation(journey.getEndLocation().getId());
        dto.setTransportOption(journey.getTransportOption().getId());
        dto.setPlannedStart(journey.getPlannedStart());
        dto.setPlannedEnd(journey.getPlannedEnd());
        dto.setCreatedAt(journey.getCreatedAt());
        dto.setUpdatedAt(journey.getUpdatedAt());
        return dto;
    }

    public Journey toEntity(JourneyDTO journeyDTO, User user, Location startLocation, Location endLocation, TransportOption transportOption){
        Journey journey = new Journey();
        journey.setId(journeyDTO.getId());
        journey.setUser(user);
        journey.setStartLocation(startLocation);
        journey.setEndLocation(endLocation);
        journey.setTransportOption(transportOption);
        journey.setPlannedStart(journeyDTO.getPlannedStart());
        journey.setPlannedEnd(journeyDTO.getPlannedEnd());
        journey.setCreatedAt(journeyDTO.getCreatedAt());
        journey.setUpdatedAt(journeyDTO.getUpdatedAt());
        return journey;
    }
}
