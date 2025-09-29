package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.IssueRequestDto;
import ch.unisg.backend.controller.http.dto.request.node.SystemRequestDto;
import lombok.Getter;

@Getter
public class RaiseRequestDto {

    public static final String MEDIA_TYPE = "application/raise+json";

    private SystemRequestDto system;
    private IssueRequestDto issue;
}
