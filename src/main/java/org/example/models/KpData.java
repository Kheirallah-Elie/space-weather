package org.example.models;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class KpData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Instant timestamp;
    private Double kp;
    private String type; // observed, estimated, predicted
    private String noaaScale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Double getKp() {
        return kp;
    }

    public void setKp(Double kp) {
        this.kp = kp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNoaaScale() {
        return noaaScale;
    }

    public void setNoaaScale(String noaaScale) {
        this.noaaScale = noaaScale;
    }
}