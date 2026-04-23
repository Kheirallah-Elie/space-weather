package org.example.mapper;

import org.example.external.dto.mag.MagDataDto;
import org.example.external.dto.mag.MagResponseDto;
import org.example.models.MagData;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MagDataMapper {
    private static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public List<MagData> merge(MagResponseDto response) {

        Map<LocalDateTime, MagData> map = new HashMap<>();

        mapMagData(response.getMagData(), map);

        return map.values().stream().toList();
    }

    private void mapMagData(List<MagDataDto> magData,
                            Map<LocalDateTime, MagData> map) {

        if (magData == null) return;

        for (MagDataDto m : magData) {

            LocalDateTime time = LocalDateTime.parse(m.getTime_tag(), DATE_TIME_FORMAT);

            MagData snap = map.computeIfAbsent(time, t -> {
                MagData s = new MagData();
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
}
