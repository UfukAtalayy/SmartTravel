package com.example.SmartTravel.Mapper;

import com.example.SmartTravel.DTO.WeatherInfoDTO;
import com.example.SmartTravel.Entity.Location;
import com.example.SmartTravel.Entity.WeatherInfo;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoMapper {

    public WeatherInfoDTO toDTO(WeatherInfo weatherInfo){
        WeatherInfoDTO dto = new WeatherInfoDTO();
        dto.setId(weatherInfo.getId());
        dto.setLocation(weatherInfo.getLocation().getId());
        dto.setTemperature(weatherInfo.getTemperature());
        dto.setCondition(weatherInfo.getCondition());
        dto.setUpdatedAt(weatherInfo.getUpdatedAt());
        return dto;
    }

    public WeatherInfo toEntity(WeatherInfoDTO weatherInfoDTO, Location location){
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setId(weatherInfoDTO.getId());
        weatherInfo.setLocation(location);
        weatherInfo.setTemperature(weatherInfoDTO.getTemperature());
        weatherInfo.setCondition(weatherInfoDTO.getCondition());
        weatherInfo.setUpdatedAt(weatherInfoDTO.getUpdatedAt());
        return weatherInfo;
    }
}
