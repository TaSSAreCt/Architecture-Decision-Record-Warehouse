package ch.unisg.sat.controller.http.dto.response;

import ch.unisg.sat.core.domain.aggregate.ArchitecturalKnowledge;

import java.util.HashMap;
import java.util.List;

public class ArchitecturalKnowledgeResponseDto extends ResponseDto {

    public static List<HashMap<String, Object>> toJson(ArchitecturalKnowledge architecturalKnowledge) {
        return ArchitecturalDecisionsResponseDto.toJsonVerbose(architecturalKnowledge.getArchitectureDecisions());
    }
}
