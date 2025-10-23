package ch.unisg.backend.controller.http.dto.request.relationship;

import ch.unisg.backend.controller.http.dto.request.node.ConstraintRequestDto;
import ch.unisg.backend.controller.http.dto.request.node.SystemElementRequestDto;
import lombok.Getter;

@Getter
public class ConstrainedByRequestDto {

  public static final String MEDIA_TYPE = "application/constrained-by+json";

  private SystemElementRequestDto systemElement;
  private ConstraintRequestDto constraint;
  private boolean cyber;

}
