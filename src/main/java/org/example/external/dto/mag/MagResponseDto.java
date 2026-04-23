package org.example.external.dto.mag;
import java.util.List;

public class MagResponseDto {
    private List<MagDataDto> magData;

    public MagResponseDto(List<MagDataDto> magData) {
        this.magData = magData;
    }

    public List<MagDataDto> getMagData() {
        return magData;
    }

    public void setMagData(List<MagDataDto> magData) {
        this.magData = magData;
    }
}
