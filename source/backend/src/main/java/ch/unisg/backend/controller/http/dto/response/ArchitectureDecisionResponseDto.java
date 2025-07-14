package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.controller.http.dto.response.ad.AlternativeAggregateResponseDto;
import ch.unisg.backend.controller.http.dto.response.ad.AlternativeResponseDto;
import ch.unisg.backend.controller.http.dto.response.ad.IssueResponseDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchitectureDecisionResponseDto extends ResponseDto {

    public static HashMap<String, Object> toJson(ArchitectureDecision architectureDecision) {

        HashMap<String, Object> architectureDecisionDto = new HashMap<>();

        architectureDecisionDto.put("issue", IssueResponseDto.toJson(architectureDecision.getIssue()));

        List<HashMap<String, Object>> alternativeDtoList = new ArrayList<>();

        for (AlternativeAggregate alternativeAggregate : architectureDecision.getAlternativeAggregates()) {

            alternativeDtoList.add(AlternativeResponseDto.create(alternativeAggregate.getAlternative()));
        }

        architectureDecisionDto.put("alternativeList", alternativeDtoList);

        return architectureDecisionDto;
    }

    public static HashMap<String, Object> toJsonVerbose(ArchitectureDecision architectureDecision) {
        HashMap<String, Object> architectureDecisionDto = new HashMap<>();

        architectureDecisionDto.put("issue", IssueResponseDto.toJson(architectureDecision.getIssue()));
        architectureDecisionDto.put("alternativeList", AlternativeAggregateResponseDto.toJsonVerbose(architectureDecision.getAlternativeAggregates()));

        return architectureDecisionDto;
    }
}
