package ch.unisg.backend.controller.http.dto.response.ar;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.core.domain.entities.relationships.Influence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchitecturalRequirementsResponseDto extends ResponseDto {

    public static List<HashMap<String, Object>> toJson(List<Influence> influenceList) {

        List<HashMap<String, Object>> architecturalRequirementsDto = new ArrayList<>();

        return architecturalRequirementsDto;


    }
}
