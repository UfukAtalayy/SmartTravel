package com.example.SmartTravel.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity@Table(name = "journeys")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "journeys_user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "start_location_id",nullable = false,foreignKey = @ForeignKey(name = "journeys_start_location_id"))
    private Location startLocation;

    @ManyToOne
    @JoinColumn(name = "end_location_id",nullable = false,foreignKey = @ForeignKey(name = "journeys_end_location_id"))
    private Location endLocation;

    @ManyToOne
    @JoinColumn(name = "transport_option_id",nullable = false,foreignKey = @ForeignKey(name = "journeys_transport_option_id"))
    private TransportOption transportOption;

    @Column(name = "planned_start",nullable = false)
    private LocalDateTime plannedStart = LocalDateTime.now();

    @Column(name = "planned_end")
    private LocalDateTime plannedEnd;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public TransportOption getTransportOption() {
        return transportOption;
    }

    public void setTransportOption(TransportOption transportOption) {
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
