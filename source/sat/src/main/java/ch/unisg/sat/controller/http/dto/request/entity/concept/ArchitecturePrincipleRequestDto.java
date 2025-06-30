package ch.unisg.sat.controller.http.dto.request.entity.concept;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ArchitecturePrincipleRequestDto {

    public static final String MEDIA_TYPE = "application/architecture-principle+json";

    private UUID id;
    private String title;
}
