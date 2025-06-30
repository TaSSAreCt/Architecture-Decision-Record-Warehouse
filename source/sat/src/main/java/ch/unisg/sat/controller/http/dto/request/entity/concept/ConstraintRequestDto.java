package ch.unisg.sat.controller.http.dto.request.entity.concept;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ConstraintRequestDto {

    public final static String MEDIA_TYPE = "application/constraint+json";

    private UUID id;
    private String title;

    @Getter
    public static class IntentionRequestDto {

        public static final String MEDIA_TYPE = "application/intention+json";

        private UUID id;
        private String title;
    }
}
