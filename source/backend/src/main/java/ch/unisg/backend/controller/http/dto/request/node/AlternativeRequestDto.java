package ch.unisg.backend.controller.http.dto.request.node;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AlternativeRequestDto {

    public static final String MEDIA_TYPE = "application/alternative+json";

    private UUID id;
    private String title;
}
