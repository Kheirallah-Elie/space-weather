package org.example.external.dto;

public class KpForecastDto {

    private String time_tag;
    private Double kp;
    private String observed;
    private String noaa_scale;

    public String getTime_tag() {
        return time_tag;
    }

    public void setTime_tag(String time_tag) {
        this.time_tag = time_tag;
    }

    public Double getKp() {
        return kp;
    }

    public void setKp(Double kp) {
        this.kp = kp;
    }

    public String getObserved() {
        return observed;
    }

    public void setObserved(String observed) {
        this.observed = observed;
    }

    public String getNoaa_scale() {
        return noaa_scale;
    }

    public void setNoaa_scale(String noaa_scale) {
        this.noaa_scale = noaa_scale;
    }
}
