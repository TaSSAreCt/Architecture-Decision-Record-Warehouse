package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.SystemRequestDto;
import lombok.Getter;

@Getter
public class PartOfRequestDto {

    public static final String MEDIA_TYPE = "application/part-of+json";

    private SystemRequestDto parentSystemClass;
    private SystemRequestDto childSystemClass;
}
