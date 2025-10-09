package com.example.SmartTravel.Controller;

import com.example.SmartTravel.DTO.TransportOptionDTO;
import com.example.SmartTravel.Service.TransportOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transportoption")
public class TransportOptionController {

    @Autowired
    private TransportOptionService transportOptionService;

    @GetMapping
    public List<TransportOptionDTO> getAllTransportOptions(){
        return transportOptionService.getAllTransportOptions();
    }

    @GetMapping("/{id}")
    public TransportOptionDTO getTransportOptionById(@PathVariable Long id){
        return transportOptionService.getTransportOptionById(id);
    }

    @PostMapping
    public TransportOptionDTO createTransportOption(@RequestBody TransportOptionDTO transportOptionDTO){
       return transportOptionService.crateTransportOption(transportOptionDTO);
    }

    @PutMapping("/{id}")
    public TransportOptionDTO updateTransportOption(@PathVariable Long id, @RequestBody TransportOptionDTO transportOptionDTO){
        return transportOptionService.updateTransportOption(id, transportOptionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTransportOption(@PathVariable Long id){
        transportOptionService.deleteTransportOption(id);
    }

}
