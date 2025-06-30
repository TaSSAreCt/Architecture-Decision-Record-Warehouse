package ch.unisg.sat.controller.http.dto.response.ad;

import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ArchitectureRationaleResponseDto {

    private static final String LOCATION = "http://localhost:4000/api/v1/";

    public static String uri(UUID id) {
        return LOCATION + id.toString();
    }

    public static List<HashMap<String, Object>> toJson(List<ArchitectureRationale> architectureRationales) {

        List<HashMap<String, Object>> architectureRationalesResponseDto = new ArrayList<>();

        architectureRationales.forEach(architectureRationale -> {
            HashMap<String, Object> architectureRationaleResponseDto = new HashMap<>();

            architectureRationaleResponseDto.put("id", architectureRationale.getId());
            architectureRationaleResponseDto.put("title", architectureRationale.getTitle());
            architectureRationaleResponseDto.put("context", architectureRationale.getContext());
            architectureRationaleResponseDto.put("decision", architectureRationale.getDecision());
            architectureRationaleResponseDto.put("status", architectureRationale.getStatus());
            architectureRationaleResponseDto.put("consequences", architectureRationale.getConsequences());

            architectureRationalesResponseDto.add(architectureRationaleResponseDto);
        });

        return architectureRationalesResponseDto;

    }

    public static HashMap<String, Object> create(ArchitectureRationale architectureRationale) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", architectureRationale.getId().toString());
        result.put("title", architectureRationale.getTitle());

        return result;
    }
}
