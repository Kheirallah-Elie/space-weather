package org.example.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MagData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private LocalDateTime timestamp;
    private Double bx;
    private Double by;
    private Double bz;
    private Double lon;
    private Double lat;
    private Double bt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getBx() {
        return bx;
    }

    public void setBx(Double bx) {
        this.bx = bx;
    }

    public Double getBy() {
        return by;
    }

    public void setBy(Double by) {
        this.by = by;
    }

    public Double getBz() {
        return bz;
    }

    public void setBz(Double bz) {
        this.bz = bz;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getBt() {
        return bt;
    }

    public void setBt(Double bt) {
        this.bt = bt;
    }
}
