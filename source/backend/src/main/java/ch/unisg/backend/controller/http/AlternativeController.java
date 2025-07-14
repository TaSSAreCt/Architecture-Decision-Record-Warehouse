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

    @PostMapping(path = "/alternatives", consumes = AlternativeRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createAlternative(
            @RequestBody AlternativeRequestDto payload
    ) {

        AlternativeCommand command = AlternativeCommand.create(payload.getId(), payload.getTitle());

        alternativeUseCase.createAlternative(command);

        return ResponseEntity.created(URI.create("http://localhost:4000/api/v1/alternatives/" + command.id())).build();
    }


    @PostMapping(path = "/issues/{issueId}/alternatives", consumes = AlternativeRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createAlternative(
            @RequestBody AlternativeRequestDto payload,
            @PathVariable UUID issueId
    ) {

        CreateAlternativeWithIssueCommand command = CreateAlternativeWithIssueCommand.create(payload.getId(), payload.getTitle(), issueId);

        alternativeUseCase.create(command);

        return ResponseEntity.created(URI.create("http://localhost:4000/api/v1/alternatives/" + command.id())).build();
    }

    @GetMapping(path = "/alternatives/{alternativeId}")
    public ResponseEntity<HashMap<String, Object>> getAlternativeById(
            @PathVariable UUID alternativeId
    ) {
        AlternativeQuery query = new AlternativeQuery(alternativeId);

        Alternative alternative = alternativeUseCase.findAlternativeById(query);

        return ResponseEntity.ok(AlternativeResponseDto.create(alternative));

    }
}
