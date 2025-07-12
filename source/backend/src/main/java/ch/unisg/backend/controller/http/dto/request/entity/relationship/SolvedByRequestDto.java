package ch.unisg.backend.controller.http.dto.request.entity.relationship;

import ch.unisg.backend.controller.http.dto.request.entity.concept.AlternativeRequestDto;
import ch.unisg.backend.controller.http.dto.request.entity.concept.IssueRequestDto;
import lombok.Getter;

@Getter
public class SolvedByRequestDto {

    public static final String MEDIA_TYPE = "application/solved-by+json";

    private AlternativeRequestDto alternative;
    private IssueRequestDto issue;

}
