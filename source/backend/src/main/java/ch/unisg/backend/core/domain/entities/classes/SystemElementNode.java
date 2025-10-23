package ch.unisg.backend.core.domain.entities.classes;

import java.util.UUID;

public class SystemElementNode extends Node {

  private SystemElementNode(UUID id, String title) {
    super(id, title);

  }

  public static SystemElementNode create(UUID id, String title) {
    return new SystemElementNode(id, title);
  }

}
