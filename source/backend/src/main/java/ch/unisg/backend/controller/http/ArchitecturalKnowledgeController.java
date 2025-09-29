package ch.unisg.backend.controller.http;

import ch.unisg.backend.controller.http.dto.request.node.ArchitectureRequirementRequestDto;
import ch.unisg.backend.controller.http.dto.response.*;
import ch.unisg.backend.controller.http.dto.response.ar.ArchitectureRequirementResponseDto;
import ch.unisg.backend.controller.http.dto.response.cpsos.SystemClassResponseDto;
import ch.unisg.backend.core.domain.aggregate.*;
import ch.unisg.backend.core.domain.entities.classes.ar.ArchitectureRequirement;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.port.in.SoftwareArchitectureUseCase;
import ch.unisg.backend.core.port.in.command.CreateArchitectureRequirement;
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

    private final SoftwareArchitectureUseCase adrwUseCase;

    /**
     *
     *
     */
    @GetMapping(path = "/architectural-requirements")
    public ResponseEntity<HashMap<String, Object>> getArchitecturalRequirements() {

        ArchitectureRequirement architecturalRequirements = adrwUseCase.getArchitecturalRequirements();

        return ResponseEntity.ok(ArchitectureRequirementResponseDto.toJson(architecturalRequirements));
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
                payload.getType()
        );

        adrwUseCase.create(command);

        return ResponseEntity.created(ArchitectureRequirementResponseDto.uri(command.id())).build();
    }

    /**
     *
     *
     */
    @GetMapping(path = "/architectural-knowledge")
    public ResponseEntity<HashMap<String, Object>> getArchitecturalKnowledge() {

        ArchitecturalKnowledge architecturalKnowledge = adrwUseCase.getArchitecturalKnowledge();

        return ResponseEntity.ok(ArchitecturalKnowledgeResponseDto.toJson(architecturalKnowledge));
    }

    /**
     *
     *
     */
    @GetMapping(path = "/cpsos")
    public ResponseEntity<List<HashMap<String, Object>>> getSoftwareArchitectureRepresentation() {

        List<SystemClass> cpsos = adrwUseCase.getSystemsOfSystems();

        return ResponseEntity.ok(SystemClassResponseDto.toJson(cpsos));
    }


}
