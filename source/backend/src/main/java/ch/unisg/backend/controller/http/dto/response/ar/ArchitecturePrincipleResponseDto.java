package ch.unisg.backend.controller.http.dto.response.ar;

import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturePrinciple;

import java.net.URI;
import java.util.HashMap;
import java.util.UUID;

public class ArchitecturePrincipleResponseDto {

    private static final String LOCATION = "http://localhost:4000/api/v1/";

    public static URI uri(UUID id) {
        return URI.create(LOCATION + id.toString());
    }

    public static HashMap<String, Object> create(ArchitecturePrinciple architecturePrinciple) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", architecturePrinciple.getId().toString());
        result.put("title", architecturePrinciple.getTitle());

        return result;
    }
}
