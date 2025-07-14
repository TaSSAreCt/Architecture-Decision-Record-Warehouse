package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.NonFunctionalRequirementRequestDto;
import ch.unisg.backend.controller.http.dto.request.node.SystemRequestDto;
import lombok.Getter;

@Getter
public class RequireRequestDto {

    public final static String MEDIA_TYPE = "application/require+json";

    private SystemRequestDto systemClass;
    private NonFunctionalRequirementRequestDto nonFunctionalRequirement;
}
