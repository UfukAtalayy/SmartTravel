package com.example.SmartTravel.Service;

import com.example.SmartTravel.DTO.WeatherInfoDTO;
import com.example.SmartTravel.Entity.Location;
import com.example.SmartTravel.Entity.WeatherInfo;
import com.example.SmartTravel.Mapper.WeatherInfoMapper;
import com.example.SmartTravel.Repository.LocationRepository;
import com.example.SmartTravel.Repository.WeatherInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherInfoService {

    @Autowired
    private WeatherInfoRepository weatherInfoRepository;

    @Autowired
    private WeatherInfoMapper weatherInfoMapper;

    @Autowired
    private LocationRepository locationRepository;

    public List<WeatherInfoDTO> getAllWeatherInfo(){
        return weatherInfoRepository.findAll()
                .stream()
                .map(weatherInfoMapper::toDTO)
                .collect(Collectors.toList());
    }
    public WeatherInfoDTO getWeatherInfoById(Long id){
        WeatherInfo weatherInfo = weatherInfoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Weather info not found with id:"+id));
        return weatherInfoMapper.toDTO(weatherInfo);
    }

    public WeatherInfoDTO createWeatherInfo(WeatherInfoDTO weatherInfoDTO){
        Location location = locationRepository.findById(weatherInfoDTO.getLocation())
                .orElseThrow(()->new RuntimeException("Location not found"));
        WeatherInfo weatherInfo = weatherInfoMapper.toEntity(weatherInfoDTO,location);
        return weatherInfoMapper.toDTO(weatherInfoRepository.save(weatherInfo));
    }

    public WeatherInfoDTO updateWeatherInfo(Long id,WeatherInfoDTO weatherInfoDTO){
        WeatherInfo weatherInfo = weatherInfoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Weather info not found"));
        weatherInfo.setTemperature(weatherInfoDTO.getTemperature());
        weatherInfo.setCondition(weatherInfoDTO.getCondition());
        weatherInfo.setUpdatedAt(weatherInfoDTO.getUpdatedAt());

        Location location = locationRepository.findById(weatherInfoDTO.getLocation())
                .orElseThrow(()->new RuntimeException("Location not found"));
        weatherInfo.setLocation(location);
        return weatherInfoMapper.toDTO(weatherInfoRepository.save(weatherInfo));
    }

    public void deleteWeatherInfo(Long id){
        weatherInfoRepository.deleteById(id);
    }
}
