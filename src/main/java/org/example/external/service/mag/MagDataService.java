package org.example.external.service.mag;

import org.example.external.dto.mag.MagDataDto;
import org.example.external.dto.mag.MagResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagDataService {
    private List<MagDataDto> magCache;

    public synchronized void updateMag(List<MagDataDto> mag) {
        this.magCache = mag;
    }

    public MagResponseDto getMagCachedData() {
        return new MagResponseDto(magCache);
    }
}