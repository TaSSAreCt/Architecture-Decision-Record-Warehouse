package ch.unisg.sat.controller.http.dto.request.entity.concept;

import lombok.Getter;

import java.util.UUID;

@Getter
public class NonFunctionalRequirementRequestDto {

    public final static String MEDIA_TYPE = "application/non-functional-requirement+json";

    private UUID id;
    private String title;
}
