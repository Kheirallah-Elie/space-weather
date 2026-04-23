package org.example.external.service.kp;

import org.example.external.dto.kp.KpDataDto;
import org.example.external.dto.kp.KpResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KpDataService {
    private List<KpDataDto> kpCache;

    public synchronized void updateKp(List<KpDataDto> mag) {
        this.kpCache = mag;
    }

    public KpResponseDto getKpCachedData() {
        return new KpResponseDto(kpCache);
    }
}