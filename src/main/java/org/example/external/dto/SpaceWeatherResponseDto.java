package org.example.external.dto;

import org.example.external.dto.kp.KpDataDto;
import org.example.external.dto.mag.MagDataDto;
import org.example.external.dto.plasma.PlasmaDataDto;

import java.util.List;

public class SpaceWeatherResponseDto {

    private List<MagDataDto> magData;
    private List<PlasmaDataDto> plasmaData;
    private List<KpDataDto> kpData;

    public SpaceWeatherResponseDto(List<MagDataDto> magData,
                                   List<PlasmaDataDto> plasmaData,
                                   List<KpDataDto> kpData) {
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

    public List<KpDataDto> getKpData() {
        return kpData;
    }
}