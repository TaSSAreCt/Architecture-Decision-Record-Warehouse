package ch.unisg.backend.controller.http.dto.request.entity.concept;

import lombok.Getter;

import java.util.UUID;

@Getter
public class SystemRequestDto {

    public final static String MEDIA_TYPE = "application/system+json";

    private UUID id;
    private String title;
}
