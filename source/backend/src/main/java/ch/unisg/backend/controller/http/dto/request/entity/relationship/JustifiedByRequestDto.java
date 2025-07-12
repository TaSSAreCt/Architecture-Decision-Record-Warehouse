package ch.unisg.backend.controller.http.dto.request.entity.relationship;

import ch.unisg.backend.controller.http.dto.request.entity.concept.AlternativeRequestDto;
import ch.unisg.backend.controller.http.dto.request.entity.concept.ArchitectureRationaleRequestDto;
import lombok.Getter;

@Getter
public class JustifiedByRequestDto {

    public static final String MEDIA_TYPE = "application/justified-by+json";

    private ArchitectureRationaleRequestDto architectureRationale;
    private AlternativeRequestDto alternative;
}
