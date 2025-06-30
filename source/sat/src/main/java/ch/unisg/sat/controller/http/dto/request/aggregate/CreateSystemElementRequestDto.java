package ch.unisg.sat.controller.http.dto.request.aggregate;

import ch.unisg.sat.controller.http.dto.request.entity.concept.SystemElementRequestDto;
import ch.unisg.sat.controller.http.dto.request.entity.concept.SystemRequestDto;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateSystemElementRequestDto {
    public final static String MEDIA_TYPE = "application/system-element+json";

    private UUID id;
    private String title;
}
