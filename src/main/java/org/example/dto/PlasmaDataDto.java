package org.example.dto;

public class PlasmaDataDto {
    private String time_tag;
    private Double density;
    private Double speed;
    private Double temperature;

    public String getTime_tag() {
        return time_tag;
    }

    public Double getDensity() {
        return density;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTime_tag(String time_tag) {
        this.time_tag = time_tag;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
