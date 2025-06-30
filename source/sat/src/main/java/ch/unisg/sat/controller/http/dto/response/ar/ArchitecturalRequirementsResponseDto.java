package ch.unisg.sat.controller.http.dto.response.ar;

import ch.unisg.sat.controller.http.dto.response.ResponseDto;
import ch.unisg.sat.core.domain.aggregate.ForcedBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchitecturalRequirementsResponseDto extends ResponseDto {

    public static List<HashMap<String, Object>> toJson(List<ForcedBy> architecturalRequirements) {

        List<HashMap<String, Object>> architecturalRequirementsDto = new ArrayList<>();

        architecturalRequirements.forEach(forcedBy -> {

            HashMap<String, Object> forcedByResponseDto = new HashMap<>();

            forcedByResponseDto.put("id", forcedBy.getArchitecturalRequirement().getId());
            forcedByResponseDto.put("value", forcedBy.getValue());

            HashMap<String, Object> architectureRequirementDto = new HashMap<>();

            architectureRequirementDto.put("title", forcedBy.getArchitecturalRequirement().getTitle());
            architectureRequirementDto.put("type", forcedBy.getArchitecturalRequirement().getType());

            forcedByResponseDto.put("architectureRequirement", architectureRequirementDto);

            architecturalRequirementsDto.add(forcedByResponseDto);
        });

        return architecturalRequirementsDto;


    }
}
