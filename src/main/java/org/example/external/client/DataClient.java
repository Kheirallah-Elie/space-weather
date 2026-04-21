package org.example.external.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.external.dto.KpForecastDto;
import org.example.external.dto.MagDataDto;
import org.example.external.dto.PlasmaDataDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DataClient {

    private final WebClient webClient = WebClient.create();

    // ================= MAG DATA =================
    public Mono<List<MagDataDto>> fetchMagPerMin() {
        return webClient.get()
                .uri("https://services.swpc.noaa.gov/products/solar-wind/mag-5-minute.json")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(this::mapMagData);
    }

    private List<MagDataDto> mapMagData(JsonNode node) {
        if (!node.isArray()) {
            throw new RuntimeException("Unexpected MAG API response format: " + node);
        }

        List<MagDataDto> result = new ArrayList<>();
        Iterator<JsonNode> elements = node.elements();

        boolean isHeader = true;

        while (elements.hasNext()) {
            JsonNode row = elements.next();

            if (isHeader) {
                isHeader = false;
                continue;
            }

            MagDataDto dto = new MagDataDto();

            dto.setTime_tag(getText(row, 0));
            dto.setBx_gsm(parseDouble(getNode(row, 1)));
            dto.setBy_gsm(parseDouble(getNode(row, 2)));
            dto.setBz_gsm(parseDouble(getNode(row, 3)));
            dto.setLon_gsm(parseDouble(getNode(row, 4)));
            dto.setLat_gsm(parseDouble(getNode(row, 5)));
            dto.setBt(parseDouble(getNode(row, 6)));

            result.add(dto);
        }
        return result;
    }

    // ================= PLASMA DATA =================
    public Mono<List<PlasmaDataDto>> fetchPlasmaPerMin() {
        return webClient.get()
                .uri("https://services.swpc.noaa.gov/products/solar-wind/plasma-5-minute.json")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(this::mapPlasmaData);
    }

    private List<PlasmaDataDto> mapPlasmaData(JsonNode node) {
        if (!node.isArray()) {
            throw new RuntimeException("Unexpected PLASMA API response format: " + node);
        }

        List<PlasmaDataDto> result = new ArrayList<>();
        Iterator<JsonNode> elements = node.elements();

        boolean isHeader = true;

        while (elements.hasNext()) {
            JsonNode row = elements.next();

            if (isHeader) {
                isHeader = false;
                continue;
            }

            PlasmaDataDto dto = new PlasmaDataDto();

            dto.setTime_tag(getText(row, 0));
            dto.setDensity(parseDouble(getNode(row, 1)));
            dto.setSpeed(parseDouble(getNode(row, 2)));
            dto.setTemperature(parseDouble(getNode(row, 3)));

            result.add(dto);
        }
        return result;
    }

    // ================= KP FORECAST =================
    public Mono<List<KpForecastDto>> fetchKpForecast() {
        return webClient.get()
                .uri("https://services.swpc.noaa.gov/products/noaa-planetary-k-index-forecast.json")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(this::mapKpData);
    }

    private List<KpForecastDto> mapKpData(JsonNode node) {
        List<KpForecastDto> result = new ArrayList<>();

        for (JsonNode row : node) {
            KpForecastDto dto = new KpForecastDto();
            dto.setTime_tag(row.get("time_tag").asText());
            dto.setKp(row.get("kp").asDouble());
            dto.setObserved(row.get("observed").asText());
            dto.setNoaa_scale(row.get("noaa_scale").asText());

            result.add(dto);
        }
        return result;
    }

    // ================= HELPERS =================

    private JsonNode getNode(JsonNode row, int index) {
        if (row == null || row.size() <= index) {
            return null;
        }
        return row.get(index);
    }

    private String getText(JsonNode row, int index) {
        JsonNode node = getNode(row, index);
        return node != null && !node.isNull() ? node.asText() : null;
    }

    private Double parseDouble(JsonNode node) {
        try {
            if (node == null || node.isNull()) {
                return null;
            }
            return Double.valueOf(node.asText());
        } catch (Exception e) {
            return null;
        }
    }
}