package org.example.external.dto;

import java.util.List;

public class SpaceWeatherResponseDto {

    private List<MagDataDto> magData;
    private List<PlasmaDataDto> plasmaData;
    private List<KpForecastDto> kpData;

    public SpaceWeatherResponseDto(List<MagDataDto> magData,
                                   List<PlasmaDataDto> plasmaData,
                                   List<KpForecastDto> kpData) {
        this.magData = magData;
        this.plasmaData = plasmaData;
        this.kpData = kpData;
    }

    public List<MagDataDto> getMagData() {
        return magData;
    }

    public List<PlasmaDataDto> getPlasmaData() {
        return plasmaData;
    }

    public List<KpForecastDto> getKpData() {
        return kpData;
    }
}