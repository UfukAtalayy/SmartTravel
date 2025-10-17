package com.example.SmartTravel.Repository;

import com.example.SmartTravel.Entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
}
