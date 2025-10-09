package com.example.SmartTravel.Repository;

import com.example.SmartTravel.Entity.TransportOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportOptionRepository extends JpaRepository<TransportOption,Long> {
}
