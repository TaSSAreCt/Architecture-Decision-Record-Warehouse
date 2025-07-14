package ch.unisg.backend.controller.http.dto.request.node;

import lombok.Getter;

import java.util.UUID;

@Getter
public class IssueRequestDto {

    public static final String MEDIA_TYPE = "application/issue+json";

    private UUID id;
    private String title;

}
