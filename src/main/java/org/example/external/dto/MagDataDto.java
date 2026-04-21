package org.example.external.dto;

public class MagDataDto {
    private String time_tag;
    private Double bx_gsm;
    private Double by_gsm;
    private Double bz_gsm;
    private Double lon_gsm;
    private Double lat_gsm;
    private Double bt;

    public String getTime_tag() {
        return time_tag;
    }

    public void setTime_tag(String time_tag) {
        this.time_tag = time_tag;
    }

    public Double getBx_gsm() {
        return bx_gsm;
    }

    public void setBx_gsm(Double bx_gsm) {
        this.bx_gsm = bx_gsm;
    }

    public Double getBy_gsm() {
        return by_gsm;
    }

    public void setBy_gsm(Double by_gsm) {
        this.by_gsm = by_gsm;
    }

    public Double getBz_gsm() {
        return bz_gsm;
    }

    public void setBz_gsm(Double bz_gsm) {
        this.bz_gsm = bz_gsm;
    }

    public Double getLon_gsm() {
        return lon_gsm;
    }

    public void setLon_gsm(Double lon_gsm) {
        this.lon_gsm = lon_gsm;
    }

    public Double getLat_gsm() {
        return lat_gsm;
    }

    public void setLat_gsm(Double lat_gsm) {
        this.lat_gsm = lat_gsm;
    }

    public Double getBt() {
        return bt;
    }

    public void setBt(Double bt) {
        this.bt = bt;
    }
}
