package ch.unisg.sat.controller.http;

import ch.unisg.sat.controller.http.dto.request.entity.concept.ArchitecturePrincipleRequestDto;
import ch.unisg.sat.controller.http.dto.response.ar.ArchitecturePrincipleResponseDto;
import ch.unisg.sat.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.sat.core.port.in.ArchitecturePrincipleUseCase;
import ch.unisg.sat.core.port.in.command.classes.ArchitecturePrincipleCommand;
import ch.unisg.sat.core.port.in.query.classes.ArchitecturePrincipleQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ArchitecturePrincipleController {

    private final ArchitecturePrincipleUseCase architecturePrincipleUseCase;

    @PostMapping(path = "/architectural-principles", consumes = ArchitecturePrincipleRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> createArchitecturePrinciple(
            @RequestBody ArchitecturePrincipleRequestDto payload
    ) {
        ArchitecturePrincipleCommand command = ArchitecturePrincipleCommand.create(
                payload.getId(),
                payload.getTitle()
        );

        architecturePrincipleUseCase.create(command);

        return ResponseEntity.created(ArchitecturePrincipleResponseDto.uri(command.id())).build();
    }

    @GetMapping(path = "/architectural-principles/{architecturePrincipleId}")
    public ResponseEntity<HashMap<String, Object>> findArchitecturePrincipleById(
            @PathVariable UUID architecturePrincipleId
    ) {

        ArchitecturePrincipleQuery query = ArchitecturePrincipleQuery.create(architecturePrincipleId);

        ArchitecturePrinciple architecturePrinciple = architecturePrincipleUseCase.findById(query);

        return ResponseEntity.ok(ArchitecturePrincipleResponseDto.create(architecturePrinciple));}
}
