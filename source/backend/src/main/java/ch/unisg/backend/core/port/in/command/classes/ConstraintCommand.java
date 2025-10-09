package ch.unisg.backend.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record ConstraintCommand(
    @NonNull UUID id,
    @NonNull String title,
    boolean isCyber) {

  public ConstraintCommand(
      UUID id,
      String title,
      boolean isCyber) {
    this.id = id;
    this.title = title;
    this.isCyber = isCyber;
  }

  public ConstraintCommand(String title) {
    this(UUID.randomUUID(), title, true);
  }

  public static ConstraintCommand create(UUID id) {
    return new ConstraintCommand(id, "", true);
  }

  public static ConstraintCommand create(String title) {
    return new ConstraintCommand(UUID.randomUUID(), title, true);
  }

  public static ConstraintCommand create(UUID id, String title) {
    return new ConstraintCommand(id, title, true);
  }

  public static ConstraintCommand create(UUID id, String title, boolean isCyber) {
    return new ConstraintCommand(id, title, isCyber);
  }
}
