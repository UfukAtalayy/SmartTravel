package com.example.SmartTravel.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "routes")
public class Route {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "start_location_id",nullable = false,foreignKey = @ForeignKey(name = "fk_routes_start_location_id"))
    private Location startLocation;

    @ManyToOne
    @JoinColumn(name = "end_location_id",nullable = false,foreignKey = @ForeignKey(name = "fk_routes_end_location_id"))
    private Location endLocation;

    @ManyToOne
    @JoinColumn(name = "transport_option_id",nullable = false,foreignKey = @ForeignKey(name = "fk_routes_transport_option_id"))
    private TransportOption transportOption;

    @Column(name = "distance_km")
    private Double distance;

    @Column(name = "estimated_time_min")
    private Integer estimatedTime;

    @Column(name = "created_at")
    private LocalDateTime cratedAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(LocalDateTime cratedAt) {
        this.cratedAt = cratedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
