package ch.unisg.backend.controller.http;

import ch.unisg.backend.controller.http.dto.request.aggregate.CreateSystemRequestDto;
import ch.unisg.backend.controller.http.dto.response.cpsos.SystemClassListResponseDto;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClassList;
import ch.unisg.backend.core.port.in.SystemUseCase;
import ch.unisg.backend.core.port.in.command.classes.SystemCommand;
import ch.unisg.backend.core.port.in.query.classes.SystemQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SystemController {

    private final SystemUseCase systemUseCase;

    @PostMapping(path = "/systems", consumes = CreateSystemRequestDto.MEDIA_TYPE)
    public ResponseEntity<String> addSystem(
            @RequestBody CreateSystemRequestDto payload
    ) {
        SystemCommand command = SystemCommand.create(payload.getId(), payload.getTitle());

        systemUseCase.addSystem(command);

        return new ResponseEntity<>(command.id().toString(), HttpStatus.CREATED);
    }

    @GetMapping(path = "/systems/{systemId}")
    public ResponseEntity<HashMap<String, Object>> getSystemById(
            @PathVariable UUID systemId
    ) {
        SystemQuery query = new SystemQuery(systemId);

        SystemClass systemClass = systemUseCase.getSystemById(query);

        return ResponseEntity.ok(systemClass.toJSON());
    }

    @GetMapping(path = "/systems")
    public ResponseEntity<ArrayList<Object>> getSystems() {

        SystemClassList systemClassList = systemUseCase.getSystemList();

        return ResponseEntity.ok(SystemClassListResponseDto.toJson(systemClassList));
    }

}
