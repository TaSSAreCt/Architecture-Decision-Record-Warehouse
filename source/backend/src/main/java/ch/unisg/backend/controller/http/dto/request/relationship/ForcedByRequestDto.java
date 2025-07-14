package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.AlternativeRequestDto;
import ch.unisg.backend.controller.http.dto.request.node.ArchitectureRequirementRequestDto;
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
