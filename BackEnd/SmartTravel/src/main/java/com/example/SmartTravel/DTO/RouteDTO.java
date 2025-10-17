package com.example.SmartTravel.DTO;

import java.time.LocalDateTime;

public class RouteDTO {

    private Long id;
    private Long startLocation;
    private Long endLocation;
    private Long transportOption;
    private Double distance;
    private Integer estimatedTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Long startLocation) {
        this.startLocation = startLocation;
    }

    public Long getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Long endLocation) {
        this.endLocation = endLocation;
    }

    public Long getTransportOption() {
        return transportOption;
    }

    public void setTransportOption(Long transportOption) {
        this.transportOption = transportOption;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
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
