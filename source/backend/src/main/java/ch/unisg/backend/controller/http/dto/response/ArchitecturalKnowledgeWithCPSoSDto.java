package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.core.domain.aggregate.ArchitectureDecisionRecordWarehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchitecturalKnowledgeWithCPSoSDto extends ResponseDto {
    public static List<HashMap<String, Object>> toJson(ArchitectureDecisionRecordWarehouse softwareArchitecture) {

        List<HashMap<String, Object>> architecturalKnowledgeWithCPSoSDto = new ArrayList<>();

        softwareArchitecture.getSystemsOfSystems().forEach(systemOfSystems -> {

            architecturalKnowledgeWithCPSoSDto.add(SystemOfSystemsResponseDto.toJson(systemOfSystems));

        });
        return architecturalKnowledgeWithCPSoSDto;

    }
}
