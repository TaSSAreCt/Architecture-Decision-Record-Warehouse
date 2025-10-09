package ch.unisg.backend.controller.http;

import ch.unisg.backend.controller.http.dto.request.CreateSystemElementRequestDto;
import ch.unisg.backend.controller.http.dto.response.cpsos.SystemElementResponseDto;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.backend.core.port.in.SystemElementUseCase;
import ch.unisg.backend.core.port.in.command.CreateSystemElementCommand;
import ch.unisg.backend.core.port.in.query.SystemElementQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
      @PathVariable UUID systemId) throws URISyntaxException {

    CreateSystemElementCommand command = CreateSystemElementCommand.create(
        payload.getId(),
        payload.getTitle(),
        payload.isCyber(),
        systemId);

    systemElementUseCase.addSystemElement(command);

    return ResponseEntity.created(SystemElementResponseDto.uri(command.id())).build();
  }

  @GetMapping(path = "/system-elements/{systemElementId}")
  public ResponseEntity<HashMap<String, Object>> getSystemElementById(
      @PathVariable UUID systemElementId) {

    SystemElementQuery query = new SystemElementQuery(systemElementId);

    SystemElement systemElement = systemElementUseCase.getSystemElementById(query);

    return ResponseEntity.ok(SystemElementResponseDto.toJson(systemElement));

  }
}
