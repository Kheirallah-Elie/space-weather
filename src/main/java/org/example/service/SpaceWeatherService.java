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

    public void updateCache(List<MagDataDto> mag,
                            List<PlasmaDataDto> plasma,
                            List<KpForecastDto> kp) {

        if (mag == null || plasma == null || kp == null
                || mag.isEmpty() || plasma.isEmpty() || kp.isEmpty()) {
            return;
        }

        this.magCache = mag;
        this.plasmaCache = plasma;
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