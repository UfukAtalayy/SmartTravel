package com.example.SmartTravel.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "traffic_info")
public class TrafficInfo {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id",nullable = false,foreignKey=@ForeignKey(name = "fk_trafficinfo_locationid"))
    private Location location;

    @Column(name = "traffic_level")
    private String trafficLevel;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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
