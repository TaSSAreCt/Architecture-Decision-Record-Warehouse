package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.controller.http.dto.response.ar.ArchitecturePrincipleResponseDto;
import ch.unisg.backend.controller.http.dto.response.ar.ConstraintResponseDto;
import ch.unisg.backend.controller.http.dto.response.ar.IntentionResponseDto;
import ch.unisg.backend.controller.http.dto.response.ar.NonFunctionalRequirementResponseDto;
import ch.unisg.backend.core.domain.aggregate.ArchitecturalRequirements;
import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.core.domain.entities.classes.ar.Intention;
import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchitecturalRequirementsResponseDto extends ResponseDto {

    /**
     *
     *
     */
    public static HashMap<String, List<HashMap<String, Object>>> toJson(ArchitecturalRequirements architecturalRequirements) {

        HashMap<String, List<HashMap<String, Object>>> architecturalRequirementsDto = new HashMap<>();

        List<HashMap<String, Object>> constraintList = new ArrayList<>();
        List<HashMap<String, Object>> architecturalPrincipleList = new ArrayList<>();
        List<HashMap<String, Object>> intentionList = new ArrayList<>();
        List<HashMap<String, Object>> nonFunctionalRequirementList = new ArrayList<>();

        for (Constraint constraint : architecturalRequirements.getConstraint()) {
            constraintList.add(ConstraintResponseDto.create(constraint));
        }
        architecturalRequirementsDto.put("constraints", constraintList);

        for (ArchitecturePrinciple architecturePrinciple : architecturalRequirements.getArchitecturePrinciple()) {
            architecturalPrincipleList.add(ArchitecturePrincipleResponseDto.create(architecturePrinciple));
        }
        architecturalRequirementsDto.put("architecturalPrinciples", architecturalPrincipleList);

        for (Intention intention : architecturalRequirements.getIntention()) {
            intentionList.add(IntentionResponseDto.create(intention));
        }
        architecturalRequirementsDto.put("intentions", intentionList);

        for (NonFunctionalRequirement nonFunctionalRequirement : architecturalRequirements.getNonFunctionalRequirement()) {
            nonFunctionalRequirementList.add(NonFunctionalRequirementResponseDto.create(nonFunctionalRequirement));
        }
        architecturalRequirementsDto.put("nonFunctionalRequirements", nonFunctionalRequirementList);

        return architecturalRequirementsDto;

    }
}
