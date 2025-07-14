package ch.unisg.backend.controller.http.dto.request.entity.relationship;

import ch.unisg.backend.controller.http.dto.request.entity.concept.SystemElementRequestDto;
import ch.unisg.backend.controller.http.dto.request.entity.concept.SystemRequestDto;
import lombok.Getter;

@Getter
public class BelongsToRequestDto {

    public static final String MEDIA_TYPE = "application/belongs-to+json";

    private SystemRequestDto systemClass;
    private SystemElementRequestDto systemElement;
}
