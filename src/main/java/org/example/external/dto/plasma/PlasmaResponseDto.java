package org.example.external.dto.plasma;
import java.util.List;

public class PlasmaResponseDto {
    private List<PlasmaDataDto> plasmaData;

    public PlasmaResponseDto(List<PlasmaDataDto> plasmaData) {
        this.plasmaData = plasmaData;
    }

    public List<PlasmaDataDto> getPlasmaData() {
        return plasmaData;
    }

    public void setPlasmaData(List<PlasmaDataDto> plasmaData) {
        this.plasmaData = plasmaData;
    }
}
