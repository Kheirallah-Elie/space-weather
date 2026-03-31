package org.example.service;

import org.example.dto.KpForecastDto;
import org.example.dto.MagDataDto;
import org.example.dto.PlasmaDataDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DataClient {

    private final WebClient webClient = WebClient.create();

    // ================= MAG DATA =================
    public Mono<List<MagDataDto>> fetchMagPerMin() {
        return webClient.get()
                .uri("https://services.swpc.noaa.gov/products/solar-wind/mag-5-minute.json")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<List<String>>>() {})
                .map(this::mapMagData);
    }

    private List<MagDataDto> mapMagData(List<List<String>> data) {
        return data.stream()
                .skip(1) // skip header row
                .map(row -> {
                    MagDataDto dto = new MagDataDto();
                    dto.setTime_tag(row.get(0));
                    dto.setBx_gsm(parseDouble(row.get(1)));
                    dto.setBy_gsm(parseDouble(row.get(2)));
                    dto.setBz_gsm(parseDouble(row.get(3)));
                    dto.setLon_gsm(parseDouble(row.get(4)));
                    dto.setLat_gsm(parseDouble(row.get(5)));
                    dto.setBt(parseDouble(row.get(6)));
                    return dto;
                })
                .toList();
    }

    // ================= PLASMA DATA =================
    public Mono<List<PlasmaDataDto>> fetchPlasmaPerMin() {
        return webClient.get()
                .uri("https://services.swpc.noaa.gov/products/solar-wind/plasma-5-minute.json")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<List<String>>>() {})
                .map(this::mapPlasmaData);
    }

    private List<PlasmaDataDto> mapPlasmaData(List<List<String>> data) {
        return data.stream()
                .skip(1)
                .map(row -> {
                    PlasmaDataDto dto = new PlasmaDataDto();
                    dto.setTime_tag(row.get(0));
                    dto.setDensity(parseDouble(row.get(1)));
                    dto.setSpeed(parseDouble(row.get(2)));
                    dto.setTemperature(parseDouble(row.get(3)));
                    return dto;
                })
                .toList();
    }

    // ================= KP FORECAST =================
    public Mono<List<KpForecastDto>> fetchKpForecast() {
        return webClient.get()
                .uri("https://services.swpc.noaa.gov/products/noaa-planetary-k-index-forecast.json")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<List<String>>>() {})
                .map(this::mapKpData);
    }

    private List<KpForecastDto> mapKpData(List<List<String>> data) {
        return data.stream()
                .skip(1)
                .map(row -> {
                    KpForecastDto dto = new KpForecastDto();
                    dto.setTime_tag(row.get(0));
                    dto.setKp(parseDouble(row.get(1)));
                    dto.setKp(parseDouble(row.get(2)));
                    return dto;
                })
                .toList();
    }

    // ================= HELPER =================
    private Double parseDouble(String value) {
        try {
            return value != null ? Double.valueOf(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}