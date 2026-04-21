package org.example.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class KpData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private LocalDateTime timeTag;
    private Double kp;
    private String type; // observed, estimated, predicted
    private String noaaScale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeTag() {
        return timeTag;
    }

    public void setTimeTag(LocalDateTime timeTag) {
        this.timeTag = timeTag;
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