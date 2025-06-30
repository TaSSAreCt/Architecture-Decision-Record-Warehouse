package ch.unisg.sat.controller.http.dto.request.aggregate;

import ch.unisg.sat.controller.http.dto.request.entity.concept.IssueRequestDto;
import lombok.Getter;

@Getter
public class ArchitecturalKnowledgeRequestDto {

    public static final String MEDIA_TYPE = "application/architectural-knowledge+json";

    private IssueRequestDto issue;
    private AlternativeAggregateRequestDto[] alternatives;
}
