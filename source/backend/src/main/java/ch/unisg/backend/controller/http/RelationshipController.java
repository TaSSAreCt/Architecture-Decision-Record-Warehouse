package ch.unisg.backend.controller.http;

import ch.unisg.backend.controller.http.dto.request.entity.relationship.*;
import ch.unisg.backend.controller.http.dto.response.ar.ForcedByResponseDto;
import ch.unisg.backend.controller.http.dto.response.relationship.*;
import ch.unisg.backend.core.port.in.RelationshipManagerUseCase;
import ch.unisg.backend.core.port.in.command.classes.*;
import ch.unisg.backend.core.port.in.command.relationships.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RelationshipController {

    private final RelationshipManagerUseCase relationshipManagerUseCase;

    @PostMapping(path = "/relationships/solved-by", consumes = SolvedByRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createSolvedByRelationship(
            @RequestBody SolvedByRequestDto payload
    ) {

        SolvedByCommand command = SolvedByCommand.create(
                AlternativeCommand.create(payload.getAlternative().getId()),
                IssueCommand.create(payload.getIssue().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);

        return ResponseEntity.created(SolvedByResponseDto.uri(id)).build();
    }

    @PostMapping(path = "/relationships/raise", consumes = RaiseRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createRaiseRelationship(
            @RequestBody RaiseRequestDto payload
    ) {
        RaiseCommand command = RaiseCommand.create(
                IssueCommand.create(payload.getIssue().getId()),
                SystemCommand.create(payload.getSystem().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);

        return ResponseEntity.created(RaiseResponseDto.uri(id)).build();
    }

    @PostMapping(path = "/relationships/belongs-to", consumes = BelongsToRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createBelongsToRelationship(
            @RequestBody BelongsToRequestDto payload
    ) {

        BelongsToCommand command = BelongsToCommand.create(
                SystemCommand.create(payload.getSystemClass().getId()),
                SystemElementCommand.create(payload.getSystemElement().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);

        return ResponseEntity.created(BelongsToResponseDto.uri(id)).build();
    }

    @PostMapping(path = "/relationships/part-of", consumes = PartOfRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createPartOfRelationship(
            @RequestBody PartOfRequestDto payload
    ) {

        PartOfCommand command = PartOfCommand.create(
                SystemCommand.create(payload.getParentSystemClass().getId()),
                SystemCommand.create(payload.getChildSystemClass().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);

        return ResponseEntity.created(PartOfResponseDto.uri(id)).build();
    }

    @PostMapping(path = "/relationships/constrained-by", consumes = ConstrainedByRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createConstrainedByRelationship(
            @RequestBody ConstrainedByRequestDto payload
    ) {
        ConstrainedByCommand command = ConstrainedByCommand.create(
                SystemElementCommand.create(payload.getSystemElement().getId()),
                ConstraintCommand.create(payload.getConstraint().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);

        return ResponseEntity.created(ConstrainedByResponseDto.uri(id)).build();
    }

    @PostMapping(path = "/relationships/require", consumes = RequireRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createRequireRelationship(
            @RequestBody RequireRequestDto payload
    ) {

        RequireCommand command = RequireCommand.create(
                SystemCommand.create(payload.getSystemClass().getId()),
                NonFunctionalRequirementCommand.create(payload.getNonFunctionalRequirement().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);

        return ResponseEntity.created(RequireResponseDto.uri(id)).build();
    }

    @PostMapping(path = "/relationships/forced-by", consumes = ForcedByRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createForcedByRelationship(
            @RequestBody ForcedByRequestDto payload
    ) {
        ForcedByCommand command = ForcedByCommand.create(
                payload.getValue(),
                AlternativeCommand.create(payload.getAlternative().getId()),
                ArchitectureRequirementCommand.create(payload.getArchitectureRequirement().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);

        return ResponseEntity.created(ForcedByResponseDto.uri(id)).build();
    }


    @PostMapping(path = "/relationships/justified-by", consumes = JustifiedByRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createJustifiedByRelationship(
            @RequestBody JustifiedByRequestDto payload
    ) {
        JustifiedByCommand command = JustifiedByCommand.create(
                AlternativeCommand.create(payload.getAlternative().getId()),
                ArchitectureRationaleCommand.create(payload.getArchitectureRationale().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);

        return ResponseEntity.created(JustifiedByResponseDto.uri(id)).build();
    }

    @PostMapping(path = "/relationships/has", consumes = HasRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createHasRelationship(
            @RequestBody HasRequestDto payload
    ) {
        HasCommand command = HasCommand.create(
                SystemCommand.create(payload.getSystemClass().getId()),
                ArchitectureRationaleCommand.create(payload.getArchitectureRationale().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);

        return ResponseEntity.created(HasResponseDto.uri(id)).build();
    }

}
