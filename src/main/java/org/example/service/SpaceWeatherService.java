package org.example.service;

import org.example.dto.KpForecastDto;
import org.example.dto.MagDataDto;
import org.example.dto.PlasmaDataDto;
import org.example.dto.SpaceWeatherResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceWeatherService {

    private List<MagDataDto> magCache;
    private List<PlasmaDataDto> plasmaCache;
    private List<KpForecastDto> kpCache;

    public synchronized void updateMag(List<MagDataDto> mag) {
        this.magCache = mag;
    }

    public synchronized void updatePlasma(List<PlasmaDataDto> plasma) {
        this.plasmaCache = plasma;
    }

    public synchronized void updateKp(List<KpForecastDto> kp) {
            this.kpCache = kp;
    }

    public SpaceWeatherResponseDto getCachedData() {
        return new SpaceWeatherResponseDto(
                magCache,
                plasmaCache,
                kpCache
        );
    }
}