package ch.unisg.backend.controller.http.dto.request.entity.relationship;

import ch.unisg.backend.controller.http.dto.request.entity.concept.IssueRequestDto;
import ch.unisg.backend.controller.http.dto.request.entity.concept.SystemRequestDto;
import lombok.Getter;

@Getter
public class RaiseRequestDto {

    public static final String MEDIA_TYPE = "application/raise+json";

    private SystemRequestDto system;
    private IssueRequestDto issue;
}
