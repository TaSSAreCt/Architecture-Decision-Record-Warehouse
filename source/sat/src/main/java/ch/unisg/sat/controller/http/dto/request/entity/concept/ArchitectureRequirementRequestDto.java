package ch.unisg.sat.controller.http.dto.request.entity.concept;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ArchitectureRequirementRequestDto {

    public final static String MEDIA_TYPE = "application/architecture-requirement+json";

    private UUID id;
    private String title;
    private String type;
    private double value;
    private UUID alternativeId;
}
