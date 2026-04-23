package org.example.external.dto.kp;
import java.util.List;

public class KpResponseDto {
    private List<KpDataDto> kpData;

    public KpResponseDto(List<KpDataDto> kpData) {
        this.kpData = kpData;
    }

    public List<KpDataDto> getKpData() {
        return kpData;
    }

    public void setKpData(List<KpDataDto> kpData) {
        this.kpData = kpData;
    }
}
