package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.AlternativeRequestDto;
import ch.unisg.backend.controller.http.dto.request.node.ArchitectureRationaleRequestDto;
import lombok.Getter;

@Getter
public class JustifiedByRequestDto {

    public static final String MEDIA_TYPE = "application/justified-by+json";

    private ArchitectureRationaleRequestDto architectureRationale;
    private AlternativeRequestDto alternative;
}
