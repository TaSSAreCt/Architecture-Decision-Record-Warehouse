package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.ArchitectureRationaleRequestDto;
import ch.unisg.backend.controller.http.dto.request.node.SystemRequestDto;
import lombok.Getter;

@Getter
public class HasRequestDto {

    public static final String MEDIA_TYPE = "application/has+json";

    private SystemRequestDto systemClass;
    private ArchitectureRationaleRequestDto architectureRationale;

}
