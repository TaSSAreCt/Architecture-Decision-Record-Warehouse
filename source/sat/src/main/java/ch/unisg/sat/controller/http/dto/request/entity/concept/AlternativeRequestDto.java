package ch.unisg.sat.controller.http.dto.request.entity.concept;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AlternativeRequestDto {

    public static final String MEDIA_TYPE = "application/alternative+json";

    private UUID id;
    private String title;
}
