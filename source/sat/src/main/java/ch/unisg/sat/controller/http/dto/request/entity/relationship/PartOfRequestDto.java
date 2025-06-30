package ch.unisg.sat.controller.http.dto.request.entity.relationship;

import ch.unisg.sat.controller.http.dto.request.entity.concept.SystemRequestDto;
import lombok.Getter;

@Getter
public class PartOfRequestDto {

    public static final String MEDIA_TYPE = "application/part-of+json";

    private SystemRequestDto parentSystemClass;
    private SystemRequestDto childSystemClass;
}
