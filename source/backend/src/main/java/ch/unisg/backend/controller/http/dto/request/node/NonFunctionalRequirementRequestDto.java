package ch.unisg.backend.controller.http.dto.request.node;

import lombok.Getter;

import java.util.UUID;

@Getter
public class NonFunctionalRequirementRequestDto {

  public final static String MEDIA_TYPE = "application/non-functional-requirement+json";

  private UUID id;
  private String title;
  private boolean cyber;
}
