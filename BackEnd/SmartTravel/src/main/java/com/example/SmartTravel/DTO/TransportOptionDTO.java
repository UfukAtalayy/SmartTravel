package com.example.SmartTravel.DTO;

import java.time.LocalDateTime;

public class TransportOptionDTO {
    //id SERIAL PRIMARY KEY,
    //    name VARCHAR(50) NOT NULL, -- Ör: 'CAR', 'BUS', 'WALK'
    //    average_speed_kmh DECIMAL(5,2),
    //    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    //    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    private Long id;
    private String name;
    private Double averageSpeed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
