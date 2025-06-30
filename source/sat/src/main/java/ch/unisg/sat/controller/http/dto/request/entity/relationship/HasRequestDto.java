package ch.unisg.sat.controller.http.dto.request.entity.relationship;

import ch.unisg.sat.controller.http.dto.request.entity.concept.ArchitectureRationaleRequestDto;
import ch.unisg.sat.controller.http.dto.request.entity.concept.SystemRequestDto;
import lombok.Getter;

@Getter
public class HasRequestDto {

    public static final String MEDIA_TYPE = "application/has+json";

    private SystemRequestDto systemClass;
    private ArchitectureRationaleRequestDto architectureRationale;

}
