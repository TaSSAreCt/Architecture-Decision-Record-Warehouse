package ch.unisg.sat.controller.http.dto.request.entity.relationship;

import ch.unisg.sat.controller.http.dto.request.entity.concept.AlternativeRequestDto;
import ch.unisg.sat.controller.http.dto.request.entity.concept.ArchitectureRequirementRequestDto;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ForcedByRequestDto {

    public static final String MEDIA_TYPE ="application/forced-by+json";

    private UUID id;
    private double value;

    private AlternativeRequestDto alternative;
    private ArchitectureRequirementRequestDto architectureRequirement;

}
