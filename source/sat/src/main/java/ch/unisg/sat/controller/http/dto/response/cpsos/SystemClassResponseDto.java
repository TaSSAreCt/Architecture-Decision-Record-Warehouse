package ch.unisg.sat.controller.http.dto.response.cpsos;

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

    public static HashMap<String, Object> toJson(UUID id, String title) {
        HashMap <String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("title", title);
        return result;
    }
}
