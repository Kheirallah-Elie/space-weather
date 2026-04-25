package org.example.mapper;

import org.example.external.dto.kp.KpDataDto;
import org.example.external.dto.kp.KpResponseDto;
import org.example.models.KpData;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KpDataMapper {

    public List<KpData> merge(KpResponseDto response) {

        Map<Instant, KpData> map = new HashMap<>();

        mapKpData(response.getKpData(), map);

        return map.values().stream().toList();
    }

    private void mapKpData(List<KpDataDto> kpData,
                           Map<Instant, KpData> map) {

        if (kpData == null) return;

        for (KpDataDto m : kpData) {

            // Parse ISO string and explicitly treat as UTC
            Instant timestamp = LocalDateTime
                    .parse(m.getTime_tag())   // ISO-8601: 2026-04-16T00:00:00
                    .toInstant(ZoneOffset.UTC);

            KpData snap = map.computeIfAbsent(timestamp, t -> {
                KpData s = new KpData();
                s.setTimestamp(t);
                return s;
            });

            snap.setKp(m.getKp());
            snap.setNoaaScale(m.getNoaa_scale());
        }
    }
}