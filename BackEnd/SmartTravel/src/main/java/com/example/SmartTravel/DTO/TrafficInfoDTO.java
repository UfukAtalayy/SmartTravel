package com.example.SmartTravel.DTO;

import java.time.LocalDateTime;

public class TrafficInfoDTO {
    private Long id;
    private Long location;
    private String trafficLevel;
    private LocalDateTime updatedAt;

    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public String getTrafficLevel() {
        return trafficLevel;
    }

    public void setTrafficLevel(String trafficLevel) {
        this.trafficLevel = trafficLevel;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
