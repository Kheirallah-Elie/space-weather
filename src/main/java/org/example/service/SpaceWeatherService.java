package org.example.service;

import org.example.dto.CombinedDataDto;
import org.example.dto.KpForecastDto;
import org.example.dto.MagDataDto;
import org.example.dto.PlasmaDataDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceWeatherService {
    private CombinedDataDto cache;

    public void updateCache(List<MagDataDto> mag,
                            List<PlasmaDataDto> plasma,
                            List<KpForecastDto> kp) {

        if (mag == null || mag.isEmpty()
                || plasma == null || plasma.isEmpty()
                || kp == null || kp.isEmpty()) {
            return;
        }

        // get latest records (last list element)
        MagDataDto latestMag = mag.get(mag.size() - 1);
        PlasmaDataDto latestPlasma = plasma.get(plasma.size() - 1);
        KpForecastDto latestKp = kp.get(kp.size() - 1);

        cache = new CombinedDataDto(
                latestMag.getBz_gsm(),
                latestMag.getBt(),
                latestPlasma.getSpeed(),
                latestKp.getKp(),
                latestMag.getTime_tag()
        );
    }

    public CombinedDataDto getCachedData() {
        System.out.println(cache);
        return cache;
    }
}