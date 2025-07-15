package ch.unisg.backend.controller.http.dto.response.ar;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ar.ArchitectureRequirement;

import java.util.HashMap;

public class ArchitectureRequirementResponseDto extends ResponseDto {

    public ArchitectureRequirementResponseDto() {}

    public static HashMap<String, Object> toJson(ArchitectureRequirement architectureRequirement) {

        HashMap<String, Object> result = new HashMap<>();

        result.put(
                "nonFunctionalRequirementList",
                architectureRequirement
                        .getNonFunctionalRequirementList()
                        .stream().map(NonFunctionalRequirementResponseDto::create));

        result.put(
                "constraintList",
                architectureRequirement
                        .getConstraintList()
                        .stream().map(ConstraintResponseDto::toJson)
        );

        result.put(
                "intentionList",
                architectureRequirement
                        .getIntentionList()
                        .stream().map(IntentionResponseDto::create)
        );

        result.put(
                "architecturePrinciple",
                architectureRequirement
                        .getArchitecturePrincipleList()
                        .stream().map(ArchitecturePrincipleResponseDto::create)
        );

        return result;

    }
}
