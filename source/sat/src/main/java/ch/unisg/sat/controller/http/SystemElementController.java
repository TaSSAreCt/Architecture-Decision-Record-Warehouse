package ch.unisg.sat.controller.http;

import ch.unisg.sat.controller.http.dto.request.aggregate.CreateSystemElementRequestDto;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.sat.core.port.in.SystemElementUseCase;
import ch.unisg.sat.core.port.in.command.CreateSystemElementCommand;
import ch.unisg.sat.core.port.in.query.classes.SystemElementQuery;
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
public class SystemElementController {

    private final SystemElementUseCase systemElementUseCase;

    @PostMapping(path = "/systems/{systemId}/system-elements", consumes = CreateSystemElementRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> addSystemElement(
            @RequestBody CreateSystemElementRequestDto payload,
            @PathVariable UUID systemId
    ) throws URISyntaxException {

        CreateSystemElementCommand command = CreateSystemElementCommand.create(
                payload.getId(),
                payload.getTitle(),
                systemId
        );

        systemElementUseCase.addSystemElement(command);

        return ResponseEntity.created(new URI("http://localhost:4000/api/v1/system-elements/")).build();
    }

    @GetMapping(path = "/system-elements/{systemElementId}")
    public ResponseEntity<HashMap<String, Object>> getSystemElementById(
            @PathVariable UUID systemElementId
    ) {

        SystemElementQuery query = new SystemElementQuery(systemElementId);

        SystemElement systemElement = systemElementUseCase.getSystemElementById(query);

        return ResponseEntity.ok(systemElement.toJson());

    }
}
