package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.SystemElementRequestDto;
import ch.unisg.backend.controller.http.dto.request.node.SystemRequestDto;
import lombok.Getter;

@Getter
public class BelongsToRequestDto {

    public static final String MEDIA_TYPE = "application/belongs-to+json";

    private SystemRequestDto systemClass;
    private SystemElementRequestDto systemElement;
}
