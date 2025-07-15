package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.controller.http.dto.response.ad.IssueResponseDto;
import ch.unisg.backend.controller.http.dto.response.ar.ArchitectureRequirementResponseDto;
import ch.unisg.backend.core.domain.aggregate.ArchitecturalKnowledge;

import java.util.HashMap;

public class ArchitecturalKnowledgeResponseDto extends ResponseDto {

    public static HashMap<String, Object> toJson(ArchitecturalKnowledge architecturalKnowledge) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("issueList", IssueResponseDto.toJson(architecturalKnowledge.getIssueList()));
        result.put("architectureRequirementList", ArchitectureRequirementResponseDto.toJson(architecturalKnowledge.getArchitectureRequirement()));

        return result;

    }
}
