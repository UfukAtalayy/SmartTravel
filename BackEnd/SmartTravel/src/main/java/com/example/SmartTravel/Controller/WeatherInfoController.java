package com.example.SmartTravel.Controller;

import com.example.SmartTravel.DTO.WeatherInfoDTO;
import com.example.SmartTravel.Service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weatherinfo")
public class WeatherInfoController {

    @Autowired
    private WeatherInfoService weatherInfoService;

    @GetMapping
    public List<WeatherInfoDTO> getAllWeatherInfo(){
        return weatherInfoService.getAllWeatherInfo();
    }

    @GetMapping("/{id}")
    public WeatherInfoDTO getWeatherInfoById(@PathVariable Long id){
        return weatherInfoService.getWeatherInfoById(id);
    }

    @PostMapping
    public WeatherInfoDTO createWeatherInfo(@RequestBody WeatherInfoDTO weatherInfoDTO){
        return weatherInfoService.createWeatherInfo(weatherInfoDTO);
    }

    @PutMapping("/{id}")
    public WeatherInfoDTO updateWeatherInfo(@PathVariable Long id,@RequestBody WeatherInfoDTO weatherInfoDTO){
        return weatherInfoService.updateWeatherInfo(id, weatherInfoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteWeatherInfo(@PathVariable Long id){
        weatherInfoService.deleteWeatherInfo(id);
    }
}
