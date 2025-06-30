package ch.unisg.sat.controller.http.dto.response;

import ch.unisg.sat.core.domain.aggregate.ArchitecturalDecisions;
import ch.unisg.sat.core.domain.aggregate.ArchitectureDecision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchitecturalDecisionsResponseDto extends ResponseDto {

    public static List<HashMap<String, Object>> toJson(ArchitecturalDecisions architecturalDecisions) {

        List<HashMap<String, Object>> architecturalDecisionsDto = new ArrayList<>();

        for (ArchitectureDecision architectureDecision : architecturalDecisions.getValue()) {

            architecturalDecisionsDto.add(ArchitectureDecisionResponseDto.toJson(architectureDecision));
        }

        return architecturalDecisionsDto;

    }

    public static List<HashMap<String, Object>> toJsonVerbose(List<ArchitectureDecision> architecturalDecisions) {
        List<HashMap<String, Object>> architecturalDecisionsDto = new ArrayList<>();

        architecturalDecisions.forEach(architectureDecision -> {
            HashMap<String, Object> architectureDecisionDto = ArchitectureDecisionResponseDto.toJsonVerbose(architectureDecision);
            architecturalDecisionsDto.add(architectureDecisionDto);
        });

        return architecturalDecisionsDto;
    }
}
