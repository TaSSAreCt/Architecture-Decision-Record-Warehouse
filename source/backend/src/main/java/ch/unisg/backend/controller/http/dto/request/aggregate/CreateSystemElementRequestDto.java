package ch.unisg.backend.controller.http.dto.request.aggregate;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateSystemElementRequestDto {
    public final static String MEDIA_TYPE = "application/system-element+json";

    private UUID id;
    private String title;
}
