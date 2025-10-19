package com.example.SmartTravel.Repository;

import com.example.SmartTravel.Entity.TrafficInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficInfoRepository extends JpaRepository<TrafficInfo,Long> {
}
