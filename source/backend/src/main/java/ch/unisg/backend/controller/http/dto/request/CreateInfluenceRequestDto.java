package ch.unisg.backend.controller.http.dto.request;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateInfluenceRequestDto {

    public final static String MEDIA_TYPE ="application/influence+json";

    private UUID id;
    private Float value;
    private UUID architectureRequirementId;
    private UUID alternativeId;

}
