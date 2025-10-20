package com.example.SmartTravel.DTO;

import java.time.LocalDateTime;

public class JourneyDTO {

    private Long id;
    private Long user;
    private Long startLocation;
    private Long endLocation;
    private Long transportOption;
    private LocalDateTime plannedStart;
    private LocalDateTime plannedEnd;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
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

    public LocalDateTime getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(LocalDateTime plannedStart) {
        this.plannedStart = plannedStart;
    }

    public LocalDateTime getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(LocalDateTime plannedEnd) {
        this.plannedEnd = plannedEnd;
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
