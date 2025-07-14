package ch.unisg.backend.controller.http.dto.request.aggregate;

import ch.unisg.backend.controller.http.dto.request.entity.concept.ArchitectureRequirementRequestDto;
import lombok.Getter;

@Getter
public class AlternativeAggregateRequestDto {

    public static final String MEDIA_TYPE = "application/alternative-aggregate+json";

    private String id;
    private String title;
    private ArchitectureRequirementRequestDto[] architecturalRequirements;
}
