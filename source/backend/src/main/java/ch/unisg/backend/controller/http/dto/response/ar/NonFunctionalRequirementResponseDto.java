package ch.unisg.backend.controller.http.dto.response.ar;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class NonFunctionalRequirementResponseDto {

    private static final String LOCATION = "http://localhost:4000/api/v1/";

    public static URI uri(UUID id) {
        return URI.create(LOCATION + id.toString());
    }

    public static HashMap<String, Object> create(NonFunctionalRequirement nonFunctionalRequirement) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", nonFunctionalRequirement.getId().toString());
        result.put("title", nonFunctionalRequirement.getTitle());

        return result;
    }

    public static List<HashMap<String, Object>> toNonFunctionalRequirementResponseDtoList(List<NonFunctionalRequirement> nonFunctionalRequirementList) {
        return nonFunctionalRequirementList.stream().map(NonFunctionalRequirementResponseDto::create).toList();
    }
}
