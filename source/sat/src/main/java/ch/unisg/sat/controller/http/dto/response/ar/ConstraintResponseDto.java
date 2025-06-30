package ch.unisg.sat.controller.http.dto.response.ar;

import ch.unisg.sat.core.domain.entities.classes.ar.Constraint;

import java.util.HashMap;
import java.util.UUID;

public class ConstraintResponseDto {

    private static final String LOCATION = "http://localhost:4000/api/v1/";

    public static String uri(UUID id) {
        return LOCATION + id.toString();
    }

    public static HashMap<String, Object> create(Constraint constraint) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", constraint.getId().toString());
        result.put("title", constraint.getTitle());

        return result;
    }
}
