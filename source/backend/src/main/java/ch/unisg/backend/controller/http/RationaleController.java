package ch.unisg.backend.controller.http;

import ch.unisg.backend.controller.http.dto.request.node.ArchitectureRationaleRequestDto;
import ch.unisg.backend.controller.http.dto.response.ad.RationaleResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import ch.unisg.backend.core.port.in.ArchitectureRationaleUseCase;
import ch.unisg.backend.core.port.in.command.classes.ArchitectureRationaleCommand;
import ch.unisg.backend.core.port.in.query.ArchitectureRationaleQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RationaleController {

    private final ArchitectureRationaleUseCase architectureRationaleUseCase;

    @PostMapping(path = "/rationales", consumes = ArchitectureRationaleRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createArchitectureRational(
            @RequestBody ArchitectureRationaleRequestDto payload
    ) {

        ArchitectureRationaleCommand command = ArchitectureRationaleCommand.create(
                payload.getId(),
                payload.getTitle(),
                payload.getContext(),
                payload.getDecision(),
                payload.getStatus(),
                payload.getConsequences()
        );

        architectureRationaleUseCase.create(command);

        return ResponseEntity.created(RationaleResponseDto.uri(command.id())).build();
    }

    @GetMapping(path = "/rationals/{architectureRationaleId}")
    public ResponseEntity<HashMap<String, Object>> findArchitectureRationaleById(
            @PathVariable UUID architectureRationaleId
    ) {

        ArchitectureRationaleQuery query = new ArchitectureRationaleQuery(architectureRationaleId);

        Rationale rationale = architectureRationaleUseCase.findById(query);

        return ResponseEntity.ok(RationaleResponseDto.toJson(rationale));
    }

}
