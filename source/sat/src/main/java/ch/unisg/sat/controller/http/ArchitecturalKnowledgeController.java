package ch.unisg.sat.controller.http;

import ch.unisg.sat.controller.http.dto.request.aggregate.ArchitecturalKnowledgeRequestDto;
import ch.unisg.sat.controller.http.dto.request.entity.concept.ArchitectureRequirementRequestDto;
import ch.unisg.sat.controller.http.dto.response.*;
import ch.unisg.sat.core.domain.aggregate.*;
import ch.unisg.sat.core.port.in.SoftwareArchitectureUseCase;
import ch.unisg.sat.core.port.in.command.CreateArchitectureRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 *
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ArchitecturalKnowledgeController {

    private final SoftwareArchitectureUseCase softwareArchitectureUseCase;

    /**
     *
     *
     */
    @GetMapping(path = "/architectural-requirements")
    public ResponseEntity<HashMap<String, List<HashMap<String, Object>>>> getArchitecturalRequirements() {

        ArchitecturalRequirements architecturalRequirements = softwareArchitectureUseCase.getArchitecturalRequirements();

        return ResponseEntity.ok(ArchitecturalRequirementsResponseDto.toJson(architecturalRequirements));
    }

    /**
     *
     */
    @PostMapping(path = "/architectural-requirements", consumes = ArchitectureRequirementRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createArchitectureRequirement(
            @RequestBody ArchitectureRequirementRequestDto payload
    ) {

        CreateArchitectureRequirement command = CreateArchitectureRequirement.create(
                payload.getId(),
                payload.getTitle(),
                payload.getValue(),
                payload.getType(),
                payload.getAlternativeId()
        );

        softwareArchitectureUseCase.create(command);

        return ResponseEntity.created(ArchitecturalRequirementsResponseDto.uri(command.id())).build();
    }

    /**
     *
     *
     */
    @GetMapping(path = "/architectural-decisions")
    public ResponseEntity<List<HashMap<String, Object>>> getArchitecturalDecisions() {

        ArchitecturalDecisions architecturalDecisions = softwareArchitectureUseCase.getArchitecturalDecisions();

        return ResponseEntity.ok(ArchitecturalDecisionsResponseDto.toJson(architecturalDecisions));
    }

    /**
     *
     *
     */
    @GetMapping(path = "/architectural-knowledge")
    public ResponseEntity<List<HashMap<String, Object>>> getArchitecturalKnowledge() {

        ArchitecturalKnowledge architecturalKnowledge = softwareArchitectureUseCase.getArchitecturalKnowledge();

        architecturalKnowledge.getArchitectureDecisions().forEach(architectureDecision -> {
            architectureDecision.getAlternativeAggregates().forEach(alternativeAggregate -> {
                alternativeAggregate.getForcedBy().forEach(forcedBy -> {
                    System.out.println(forcedBy.getArchitecturalRequirement().getTitle());
                });
            });
        });

        return ResponseEntity.ok(ArchitecturalKnowledgeResponseDto.toJson(architecturalKnowledge));
    }

    /**
     *
     *
     */
    @PostMapping(path = "/architectural-knowledge")
    public ResponseEntity<String> addArchitecturalKnowledge(
            @RequestBody ArchitecturalKnowledgeRequestDto payload
    ) {


        /*
        CreateArchitecturalKnowledgeCommand command = CreateArchitecturalKnowledgeCommand.create(
                IssueCommand.create(payload.getIssue().getId(), payload.getIssue().getTitle()),
                AlternativeCommand.create(payload.)
        );

         */

        return ResponseEntity.ok("");
    }

    /**
     *
     *
     */
    @GetMapping(path = "/systems-of-systems")
    public ResponseEntity<List<HashMap<String, Object>>> getSystemsOfSystems() {
        List<SystemOfSystems> systemsOfSystems = softwareArchitectureUseCase.getSystemsOfSystems();
        return ResponseEntity.ok(SystemsOfSystemsResponseDto.toJson(systemsOfSystems));
    }

    /**
     *
     *
     */
    @GetMapping(path = "/architectural-knowledge-cpsos")
    public ResponseEntity<List<HashMap<String, Object>>> getSoftwareArchitectureRepresentation() {

        SoftwareArchitecture softwareArchitecture = softwareArchitectureUseCase.getSoftwareArchitectureRepresentation();

        return ResponseEntity.ok(ArchitecturalKnowledgeWithCPSoSDto.toJson(softwareArchitecture));
    }


}
