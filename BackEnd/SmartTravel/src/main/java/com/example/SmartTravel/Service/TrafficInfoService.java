package com.example.SmartTravel.Service;

import com.example.SmartTravel.DTO.TrafficInfoDTO;
import com.example.SmartTravel.Entity.Location;
import com.example.SmartTravel.Entity.TrafficInfo;
import com.example.SmartTravel.Mapper.TrafficInfoMapper;
import com.example.SmartTravel.Repository.LocationRepository;
import com.example.SmartTravel.Repository.TrafficInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrafficInfoService {

    @Autowired
    private TrafficInfoRepository trafficInfoRepository;

    @Autowired
    private TrafficInfoMapper trafficInfoMapper;

    @Autowired
    private LocationRepository locationRepository;

    public List<TrafficInfoDTO> getAllTrafficInfo(){
        return trafficInfoRepository.findAll()
                .stream()
                .map(trafficInfoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TrafficInfoDTO getTrafficInfoById(Long id){
        TrafficInfo trafficInfo = trafficInfoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Traffic info not found with id:"+id));
        return trafficInfoMapper.toDTO(trafficInfo);
    }

    public TrafficInfoDTO createTrafficInfo(TrafficInfoDTO trafficInfoDTO){
        Location location = locationRepository.findById(trafficInfoDTO.getLocation())
                .orElseThrow(()->new RuntimeException("Location not found"));
        TrafficInfo trafficInfo = trafficInfoMapper.toEntity(trafficInfoDTO,location);
        return trafficInfoMapper.toDTO(trafficInfoRepository.save(trafficInfo));
    }

    public TrafficInfoDTO updateTrafficInfo(Long id,TrafficInfoDTO trafficInfoDTO){
        TrafficInfo trafficInfo = trafficInfoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Traffic info not found"));
        trafficInfo.setTrafficLevel(trafficInfoDTO.getTrafficLevel());
        trafficInfo.setUpdatedAt(trafficInfoDTO.getUpdatedAt());

        Location location = locationRepository.findById(trafficInfoDTO.getLocation())
                .orElseThrow(()->new RuntimeException("Location not found"));
        trafficInfo.setLocation(location);
        return trafficInfoMapper.toDTO(trafficInfoRepository.save(trafficInfo));
    }

    public void deleteTrafficInfo(Long id){
        trafficInfoRepository.deleteById(id);
    }
}
