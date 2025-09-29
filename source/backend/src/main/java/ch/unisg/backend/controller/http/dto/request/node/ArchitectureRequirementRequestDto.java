package ch.unisg.backend.controller.http.dto.request.node;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ArchitectureRequirementRequestDto {

    public final static String MEDIA_TYPE = "application/architecture-requirement+json";

    private UUID id;
    private String title;
    private String type;
}
