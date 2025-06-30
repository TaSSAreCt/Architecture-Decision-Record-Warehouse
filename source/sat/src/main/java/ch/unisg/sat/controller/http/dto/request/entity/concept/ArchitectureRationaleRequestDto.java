package ch.unisg.sat.controller.http.dto.request.entity.concept;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ArchitectureRationaleRequestDto {

    public static final String MEDIA_TYPE = "application/architecture-rationale+json";

    private UUID id;
    private String title;
    private String context;
    private String decision;
    private String status;
    private String consequences;
}
