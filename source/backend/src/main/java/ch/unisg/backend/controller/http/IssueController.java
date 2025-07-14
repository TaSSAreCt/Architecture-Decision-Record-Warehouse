package ch.unisg.backend.controller.http;

import ch.unisg.backend.controller.http.dto.request.entity.concept.IssueRequestDto;
import ch.unisg.backend.controller.http.dto.response.ad.IssueResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.core.port.in.IssueUseCase;
import ch.unisg.backend.core.port.in.command.classes.IssueCommand;
import ch.unisg.backend.core.port.in.query.classes.IssueQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class IssueController {

    private final IssueUseCase issueUseCase;

    @PostMapping(path = "/issues", consumes = IssueRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createIssue(
            @RequestBody IssueRequestDto payload
    ) throws URISyntaxException {

        IssueCommand command = IssueCommand.create(payload.getId(), payload.getTitle());

        issueUseCase.createIssue(command);

        return ResponseEntity.created(new URI("http://localhost:4000/api/v1/issues/" + command.id())).build();
    }

    @GetMapping(path = "/issues/{issueId}")
    public ResponseEntity<HashMap<String, Object>> getIssueById(
            @PathVariable UUID issueId
    ) {
        IssueQuery query = new IssueQuery(issueId);

        Issue issue = issueUseCase.getIssueById(query);

        return ResponseEntity.ok(IssueResponseDto.toJson(issue));
    }

}
