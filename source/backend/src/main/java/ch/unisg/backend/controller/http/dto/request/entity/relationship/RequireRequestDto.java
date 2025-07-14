package ch.unisg.backend.controller.http.dto.request.entity.relationship;

import ch.unisg.backend.controller.http.dto.request.entity.concept.NonFunctionalRequirementRequestDto;
import ch.unisg.backend.controller.http.dto.request.entity.concept.SystemRequestDto;
import lombok.Getter;

@Getter
public class RequireRequestDto {

    public final static String MEDIA_TYPE = "application/require+json";

    private SystemRequestDto systemClass;
    private NonFunctionalRequirementRequestDto nonFunctionalRequirement;
}
