package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.AlternativeRequestDto;
import ch.unisg.backend.controller.http.dto.request.node.IssueRequestDto;
import lombok.Getter;

@Getter
public class SolvedByRequestDto {

    public static final String MEDIA_TYPE = "application/solved-by+json";

    private AlternativeRequestDto alternative;
    private IssueRequestDto issue;

}
