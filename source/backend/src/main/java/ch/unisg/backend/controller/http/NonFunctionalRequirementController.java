package ch.unisg.backend.controller.http;

import ch.unisg.backend.controller.http.dto.request.node.NonFunctionalRequirementRequestDto;
import ch.unisg.backend.controller.http.dto.response.ar.NonFunctionalRequirementResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.core.port.in.NonFunctionalRequirementUseCase;
import ch.unisg.backend.core.port.in.command.classes.NonFunctionalRequirementCommand;
import ch.unisg.backend.core.port.in.query.NonFunctionalRequirementQuery;
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
      @RequestBody NonFunctionalRequirementRequestDto payload) {
    NonFunctionalRequirementCommand command = NonFunctionalRequirementCommand.create(payload.getId(),
        payload.getTitle(), payload.isCyber());

    nonFunctionalRequirementUseCase.create(command);

    return ResponseEntity.created(NonFunctionalRequirementResponseDto.uri(command.id())).build();
  }

  @GetMapping(path = "/non-functional-requirements/{nonFunctionalRequirementId}")
  public ResponseEntity<HashMap<String, Object>> findNonFunctionalRequirementById(
      @PathVariable UUID nonFunctionalRequirementId) {
    NonFunctionalRequirementQuery query = NonFunctionalRequirementQuery.create(nonFunctionalRequirementId);

    NonFunctionalRequirement nonFunctionalRequirement = nonFunctionalRequirementUseCase.findById(query);

    return ResponseEntity.ok(NonFunctionalRequirementResponseDto.create(nonFunctionalRequirement));
  }
}
