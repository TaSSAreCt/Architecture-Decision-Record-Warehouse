package ch.unisg.sat.controller.http.dto.request.entity.concept;

import lombok.Getter;

import java.util.UUID;

@Getter
public class IssueRequestDto {

    public static final String MEDIA_TYPE = "application/issue+json";

    private UUID id;
    private String title;

}
