package ch.unisg.backend.controller.http;

import ch.unisg.backend.controller.http.dto.request.node.ConstraintRequestDto;
import ch.unisg.backend.controller.http.dto.response.ar.IntentionResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ar.Intention;
import ch.unisg.backend.core.port.in.IntentionUseCase;
import ch.unisg.backend.core.port.in.command.classes.IntentionCommand;
import ch.unisg.backend.core.port.in.query.IntentionQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class IntentionController {

    private final IntentionUseCase intentionUseCase;

    @PostMapping(path = "/intentions", consumes = ConstraintRequestDto.IntentionRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createIntention(@RequestBody ConstraintRequestDto.IntentionRequestDto payload) {

        IntentionCommand command = IntentionCommand.create(payload.getId(), payload.getTitle());

        intentionUseCase.create(command);

        return ResponseEntity.created(IntentionResponseDto.uri(command.id())).build();
    }

    @GetMapping(path = "/intentions/{intentionId}")
    public ResponseEntity<HashMap<String, Object>> getIntentionById(
            @PathVariable UUID intentionId
    ) {

        IntentionQuery query = IntentionQuery.create(intentionId);

        Intention intention = intentionUseCase.findIntentionById(query);

        return ResponseEntity.ok(IntentionResponseDto.create(intention));
    }
}
