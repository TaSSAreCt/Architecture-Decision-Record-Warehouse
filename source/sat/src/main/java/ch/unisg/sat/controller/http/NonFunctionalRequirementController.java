package ch.unisg.sat.controller.http;

import ch.unisg.sat.controller.http.dto.request.entity.concept.NonFunctionalRequirementRequestDto;
import ch.unisg.sat.controller.http.dto.response.ar.NonFunctionalRequirementResponseDto;
import ch.unisg.sat.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.sat.core.port.in.NonFunctionalRequirementUseCase;
import ch.unisg.sat.core.port.in.command.classes.NonFunctionalRequirementCommand;
import ch.unisg.sat.core.port.in.query.classes.NonFunctionalRequirementQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class NonFunctionalRequirementController {

    private final NonFunctionalRequirementUseCase nonFunctionalRequirementUseCase;

    @PostMapping(path = "/non-functional-requirements", consumes = NonFunctionalRequirementRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createNonFunctionalRequirement(
            @RequestBody NonFunctionalRequirementRequestDto payload
    ) {
        NonFunctionalRequirementCommand command = NonFunctionalRequirementCommand.create(payload.getId(), payload.getTitle());

        nonFunctionalRequirementUseCase.create(command);

        return ResponseEntity.created(NonFunctionalRequirementResponseDto.uri(command.id())).build();
    }

    @GetMapping(path = "/non-functional-requirements/{nonFunctionalRequirementId}")
    public ResponseEntity<HashMap<String, Object>> findNonFunctionalRequirementById(
            @PathVariable UUID nonFunctionalRequirementId
    ) {
        NonFunctionalRequirementQuery query = NonFunctionalRequirementQuery.create(nonFunctionalRequirementId);

        NonFunctionalRequirement nonFunctionalRequirement = nonFunctionalRequirementUseCase.findById(query);

        return ResponseEntity.ok(NonFunctionalRequirementResponseDto.create(nonFunctionalRequirement));
    }
}
