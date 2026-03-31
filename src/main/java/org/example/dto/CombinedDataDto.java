package org.example.dto;

public class CombinedDataDto {
    private Double bz;
    private Double bt;
    private Double speed;
    private Double kp;
    private String timestamp;

    public CombinedDataDto(Double bz, Double bt, Double speed, Double kp, String timestamp) {
        this.bz = bz;
        this.bt = bt;
        this.speed = speed;
        this.kp = kp;
        this.timestamp = timestamp;
    }

    public Double getBz() {
        return bz;
    }

    public void setBz(Double bz) {
        this.bz = bz;
    }

    public Double getBt() {
        return bt;
    }

    public void setBt(Double bt) {
        this.bt = bt;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getKp() {
        return kp;
    }

    public void setKp(Double kp) {
        this.kp = kp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
