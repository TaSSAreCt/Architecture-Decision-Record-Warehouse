package ch.unisg.sat.controller.http.dto.response;

import java.net.URI;
import java.util.UUID;

public class ResponseDto {

    private static final String LOCATION = "http://localhost:4000/api/v1/";

    public static URI uri(UUID id) {
        return URI.create(LOCATION + id.toString());
    }
}
