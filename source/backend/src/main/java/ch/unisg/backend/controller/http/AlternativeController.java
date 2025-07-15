package ch.unisg.backend.controller.http;

import ch.unisg.backend.controller.http.dto.request.node.AlternativeRequestDto;
import ch.unisg.backend.controller.http.dto.response.ad.AlternativeResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.port.in.AlternativeUseCase;
import ch.unisg.backend.core.port.in.command.CreateAlternativeWithIssueCommand;
import ch.unisg.backend.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.backend.core.port.in.query.AlternativeQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AlternativeController {

    private final AlternativeUseCase alternativeUseCase;

    @PostMapping(path = "/issues/{issueId}/alternatives", consumes = AlternativeRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createAlternative(
            @RequestBody AlternativeRequestDto payload,
            @PathVariable UUID issueId
    ) {

        CreateAlternativeWithIssueCommand command = CreateAlternativeWithIssueCommand.create(payload.getId(), payload.getTitle(), issueId);

        alternativeUseCase.create(command);

        return ResponseEntity.created(AlternativeResponseDto.uri(command.id())).build();
    }

    @GetMapping(path = "/issues/{issueId}/alternatives/{alternativeId}")
    public ResponseEntity<HashMap<String, Object>> getAlternativeById(
            @PathVariable UUID alternativeId,
            @PathVariable UUID issueId
    ) {
        AlternativeQuery query = new AlternativeQuery(alternativeId);

        Alternative alternative = alternativeUseCase.findAlternativeById(query);

        return ResponseEntity.ok(AlternativeResponseDto.toJson(alternative));

    }
}
