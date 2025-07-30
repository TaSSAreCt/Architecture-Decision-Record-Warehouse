package ch.unisg.backend.controller.http.dto.response.ar;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ar.*;

import java.util.HashMap;

public class ArchitectureRequirementResponseDto extends ResponseDto {

    public ArchitectureRequirementResponseDto() {}

    public static HashMap<String, Object> toJson(ArchitectureRequirementType architectureRequirement) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", architectureRequirement.getId());
        result.put("title", architectureRequirement.getTitle());

        if (architectureRequirement instanceof Constraint) {
            result.put("type", "constraint");
        }

        if (architectureRequirement instanceof Intention) {
            result.put("type", "intention");
        }

        if (architectureRequirement instanceof ArchitecturePrinciple) {
            result.put("type", "architecturePrinciple");
        }

        if (architectureRequirement instanceof NonFunctionalRequirement) {
            result.put("type", "nonFunctionalRequirement");
        }

        return result;

    }

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
                "architecturePrincipleList",
                architectureRequirement
                        .getArchitecturePrincipleList()
                        .stream().map(ArchitecturePrincipleResponseDto::create)
        );

        return result;

    }
}
