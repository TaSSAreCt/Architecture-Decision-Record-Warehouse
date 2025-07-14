package ch.unisg.backend.controller.http.dto.response.ar;

import ch.unisg.backend.core.domain.entities.classes.ar.ArchitectureRequirement;

import java.net.URI;
import java.util.HashMap;
import java.util.UUID;

public class ArchitectureRequirementResponseDto {

    private static final String LOCATION = "http://localhost:4000/api/v1/";

    public static URI uri(UUID id) {
        return URI.create(LOCATION + id.toString());
    }

    public ArchitectureRequirementResponseDto() {

    }

    public static HashMap<String, Object> toJson(ArchitectureRequirement architectureRequirement) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", architectureRequirement.getId());
        result.put("title", architectureRequirement.getTitle());
        result.put("value", architectureRequirement.getValue());

        return result;

    }
}
