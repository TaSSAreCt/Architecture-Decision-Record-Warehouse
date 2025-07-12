package ch.unisg.backend.controller.http.dto.response.ar;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NonFunctionalRequirementListResponseDto {

    public static List<HashMap<String, Object>> toJsonVerbose(List<NonFunctionalRequirement> nonFunctionalRequirements) {

        List<HashMap<String, Object>> nonFunctionalRequirementsDto = new ArrayList<>();

        nonFunctionalRequirements.forEach(nonFunctionalRequirement -> {
            nonFunctionalRequirementsDto.add(NonFunctionalRequirementResponseDto.create(nonFunctionalRequirement));
        });

        return nonFunctionalRequirementsDto;

    }
}
