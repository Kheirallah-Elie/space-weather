package org.example.mapper;

import org.example.external.dto.plasma.PlasmaDataDto;
import org.example.external.dto.plasma.PlasmaResponseDto;
import org.example.models.PlasmaData;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PlasmaDataMapper {
    private static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public List<PlasmaData> merge(PlasmaResponseDto response) {

        Map<LocalDateTime, PlasmaData> map = new HashMap<>();

        mapPlasmaData(response.getPlasmaData(), map);

        return map.values().stream().toList();
    }


    private void mapPlasmaData(List<PlasmaDataDto> plasmaData,
                               Map<LocalDateTime, PlasmaData> map) {

        if (plasmaData == null) return;

        for (PlasmaDataDto p : plasmaData) {

            LocalDateTime time = LocalDateTime.parse(p.getTime_tag(), DATE_TIME_FORMAT);

            PlasmaData snap = map.computeIfAbsent(time, t -> {
                PlasmaData s = new PlasmaData();
                s.setTimestamp(t);
                return s;
            });

            snap.setDensity(p.getDensity());
            snap.setSpeed(p.getSpeed());
            snap.setTemperature(p.getTemperature());
        }
    }
}
