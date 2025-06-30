package ch.unisg.sat.controller.http.dto.response.ar;

import ch.unisg.sat.core.domain.entities.classes.ar.Intention;

import java.net.URI;
import java.util.HashMap;
import java.util.UUID;

public class IntentionResponseDto {

    private static final String LOCATION = "http://localhost:4000/api/v1/";

    public static URI uri(UUID id) {
        return URI.create(LOCATION + id.toString());
    }

    public static HashMap<String, Object> create(Intention intention) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", intention.getId().toString());
        result.put("title", intention.getTitle());

        return result;
    }

}
