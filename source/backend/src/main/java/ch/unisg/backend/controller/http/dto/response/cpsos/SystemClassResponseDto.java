package ch.unisg.backend.controller.http.dto.response.cpsos;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import lombok.Getter;

import java.util.HashMap;
import java.util.UUID;

@Getter
public class SystemClassResponseDto {
    private final UUID id;
    private final String title;

    private SystemClassResponseDto(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public static HashMap<String, Object> toJson(SystemClass systemClass) {
        HashMap <String, Object> result = new HashMap<>();
        result.put("id", systemClass.getId());
        result.put("title", systemClass.getTitle());
        return result;
    }
}
