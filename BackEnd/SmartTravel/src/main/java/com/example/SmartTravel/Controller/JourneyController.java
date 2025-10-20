package com.example.SmartTravel.Controller;

import com.example.SmartTravel.DTO.JourneyDTO;
import com.example.SmartTravel.Service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journey")
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    @GetMapping
    public List<JourneyDTO> getAllJourneys(){
        return journeyService.getAllJourneys();
    }

    @GetMapping("/{id}")
    public JourneyDTO getJourneyById(@PathVariable Long id){
        return journeyService.getJourneyById(id);
    }

    @PostMapping
    public JourneyDTO createJourney(@RequestBody JourneyDTO journeyDTO){
        return journeyService.createJourney(journeyDTO);
    }

    @PutMapping("/{id}")
    public JourneyDTO updateJourney(@PathVariable Long id, @RequestBody JourneyDTO journeyDTO){
        return journeyService.updateJourney(id, journeyDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteJourney(@PathVariable Long id){
        journeyService.deleteJourney(id);
    }
}
