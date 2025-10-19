package com.example.SmartTravel.Repository;

import com.example.SmartTravel.Entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherInfoRepository extends JpaRepository<WeatherInfo,Long> {
}
