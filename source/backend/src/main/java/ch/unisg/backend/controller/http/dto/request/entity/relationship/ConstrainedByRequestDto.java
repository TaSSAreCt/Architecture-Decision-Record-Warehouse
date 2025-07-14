package ch.unisg.backend.controller.http.dto.request.entity.relationship;

import ch.unisg.backend.controller.http.dto.request.entity.concept.ConstraintRequestDto;
import ch.unisg.backend.controller.http.dto.request.entity.concept.SystemElementRequestDto;
import lombok.Getter;

@Getter
public class ConstrainedByRequestDto {

    public static final String MEDIA_TYPE = "application/constrained-by+json";

    private SystemElementRequestDto systemElement;
    private ConstraintRequestDto constraint;


}
