package com.example.SmartTravel.Service;

import com.example.SmartTravel.DTO.TransportOptionDTO;
import com.example.SmartTravel.Entity.TransportOption;
import com.example.SmartTravel.Mapper.TransportOptionMapper;
import com.example.SmartTravel.Repository.TransportOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportOptionService {

    @Autowired
    private TransportOptionRepository transportOptionRepository;

    @Autowired
    private TransportOptionMapper transportOptionMapper;

    public List<TransportOptionDTO> getAllTransportOptions(){
        return transportOptionRepository.findAll()
                .stream()
                .map(transportOptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TransportOptionDTO getTransportOptionById(Long id){
        TransportOption transportOption = transportOptionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Transport option not found with id:"+id));
        return transportOptionMapper.toDTO(transportOption);
    }

    public TransportOptionDTO crateTransportOption(TransportOptionDTO transportOptionDTO){
        TransportOption transportOption = transportOptionMapper.toEntity(transportOptionDTO);
        return transportOptionMapper.toDTO(transportOptionRepository.save(transportOption));
    }

    public TransportOptionDTO updateTransportOption(Long id, TransportOptionDTO transportOptionDTO){
        TransportOption transportOption = transportOptionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Transport option not found"));
        transportOption.setName(transportOptionDTO.getName());
        transportOption.setAverageSpeed(transportOptionDTO.getAverageSpeed());
        transportOption.setCreatedAt(transportOptionDTO.getCreatedAt());
        transportOption.setUpdatedAt(transportOptionDTO.getUpdatedAt());
        return transportOptionMapper.toDTO(transportOptionRepository.save(transportOption));
    }

    public void deleteTransportOption(Long id){
        transportOptionRepository.deleteById(id);
    }
}
