package com.example.SmartTravel.Service;

import com.example.SmartTravel.DTO.JourneyDTO;
import com.example.SmartTravel.Entity.*;
import com.example.SmartTravel.Mapper.JourneyMapper;
import com.example.SmartTravel.Repository.JourneyRepository;
import com.example.SmartTravel.Repository.LocationRepository;
import com.example.SmartTravel.Repository.TransportOptionRepository;
import com.example.SmartTravel.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;

    @Autowired
    private JourneyMapper journeyMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TransportOptionRepository transportOptionRepository;

    public List<JourneyDTO> getAllJourneys(){
        return journeyRepository.findAll()
                .stream()
                .map(journeyMapper::toDTO)
                .collect(Collectors.toList());
    }
    public JourneyDTO getJourneyById(Long id){
        Journey journey = journeyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Journey not found with id:"+id));
        return journeyMapper.toDTO(journey);
    }
    public void deleteJourney(Long id){
        journeyRepository.deleteById(id);
    }

    public JourneyDTO createJourney(JourneyDTO journeyDTO){
        User user = userRepository.findById(journeyDTO.getUser())
                .orElseThrow(()->new RuntimeException("User not found"));

        Location startLocation = null;
        if (journeyDTO.getStartLocation() != null){
            startLocation = locationRepository.findById(journeyDTO.getStartLocation())
                    .orElseThrow(()->new RuntimeException("Start location not found"));
        }

        Location endLocation = null;
        if (journeyDTO.getEndLocation() != null){
            endLocation = locationRepository.findById(journeyDTO.getEndLocation())
                    .orElseThrow(()->new RuntimeException("End location not found"));
        }

        TransportOption transportOption = transportOptionRepository.findById(journeyDTO.getTransportOption())
                .orElseThrow(()->new RuntimeException("Transport option not found"));
        Journey journey = journeyMapper.toEntity(journeyDTO,user,startLocation,endLocation,transportOption);
        return journeyMapper.toDTO(journeyRepository.save(journey));
    }

    public JourneyDTO updateJourney(Long id, JourneyDTO journeyDTO){
        Journey journey = journeyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Journey not found"));
        journey.setPlannedStart(journeyDTO.getPlannedStart());
        journey.setPlannedEnd(journeyDTO.getPlannedEnd());
        journey.setCreatedAt(journeyDTO.getCreatedAt());
        journey.setUpdatedAt(journeyDTO.getUpdatedAt());

        User user = userRepository.findById(journeyDTO.getUser())
                .orElseThrow(()->new RuntimeException("User not found"));
        journey.setUser(user);

        Location startLocation = locationRepository.findById(journeyDTO.getStartLocation())
                .orElseThrow(()->new RuntimeException("Start location not found"));
        journey.setStartLocation(startLocation);

        Location endLocation = locationRepository.findById(journeyDTO.getEndLocation())
                .orElseThrow(()->new RuntimeException("End location not found"));
        journey.setEndLocation(endLocation);

        TransportOption transportOption = transportOptionRepository.findById(journeyDTO.getTransportOption())
                .orElseThrow(()->new RuntimeException("Transport option not found"));
        journey.setTransportOption(transportOption);
        return journeyMapper.toDTO(journeyRepository.save(journey));
    }
}
