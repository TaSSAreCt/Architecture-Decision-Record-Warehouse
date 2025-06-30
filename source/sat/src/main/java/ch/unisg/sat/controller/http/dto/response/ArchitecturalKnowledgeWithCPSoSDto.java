package ch.unisg.sat.controller.http.dto.response;

import ch.unisg.sat.core.domain.aggregate.SoftwareArchitecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchitecturalKnowledgeWithCPSoSDto extends ResponseDto {
    public static List<HashMap<String, Object>> toJson(SoftwareArchitecture softwareArchitecture) {

        List<HashMap<String, Object>> architecturalKnowledgeWithCPSoSDto = new ArrayList<>();

        softwareArchitecture.getSystemsOfSystems().forEach(systemOfSystems -> {

            architecturalKnowledgeWithCPSoSDto.add(SystemOfSystemsResponseDto.toJson(systemOfSystems));

        });
        return architecturalKnowledgeWithCPSoSDto;

    }
}
