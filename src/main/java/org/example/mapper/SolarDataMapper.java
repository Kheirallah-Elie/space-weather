package org.example.mapper;

import org.example.external.dto.mag.MagDataDto;
import org.example.external.dto.plasma.PlasmaDataDto;
import org.example.external.dto.SpaceWeatherResponseDto;
import org.example.models.SolarSnapshot;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SolarDataMapper {

    private static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");


    public List<SolarSnapshot> merge(SpaceWeatherResponseDto response) {

        Map<LocalDateTime, SolarSnapshot> map = new HashMap<>();

        mapMagData(response.getMagData(), map);
        mapPlasmaData(response.getPlasmaData(), map);

        return map.values().stream().toList();
    }

    private void mapMagData(List<MagDataDto> magData,
                            Map<LocalDateTime, SolarSnapshot> map) {

        if (magData == null) return;

        for (MagDataDto m : magData) {

            LocalDateTime time = LocalDateTime.parse(m.getTime_tag(), DATE_TIME_FORMAT);

            SolarSnapshot snap = map.computeIfAbsent(time, t -> {
                SolarSnapshot s = new SolarSnapshot();
                s.setTimestamp(t);
                return s;
            });

            snap.setBx(m.getBx_gsm());
            snap.setBy(m.getBy_gsm());
            snap.setBz(m.getBz_gsm());
            snap.setLon(m.getLon_gsm());
            snap.setLat(m.getLat_gsm());
            snap.setBt(m.getBt());
        }
    }

    private void mapPlasmaData(List<PlasmaDataDto> plasmaData,
                               Map<LocalDateTime, SolarSnapshot> map) {

        if (plasmaData == null) return;

        for (PlasmaDataDto p : plasmaData) {

            LocalDateTime time = LocalDateTime.parse(p.getTime_tag(), DATE_TIME_FORMAT);

            SolarSnapshot snap = map.computeIfAbsent(time, t -> {
                SolarSnapshot s = new SolarSnapshot();
                s.setTimestamp(t);
                return s;
            });

            snap.setDensity(p.getDensity());
            snap.setSpeed(p.getSpeed());
            snap.setTemperature(p.getTemperature());
        }
    }
}