package ch.unisg.backend.core.domain.entities.classes;

import java.util.UUID;

public class ConstraintNode extends Node {

  private ConstraintNode(UUID id, String title) {
    super(id, title);
  }

  public static ConstraintNode create(UUID id, String title) {
    return new ConstraintNode(id, title);
  }

}
