package ch.unisg.backend.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record NonFunctionalRequirementCommand(
    @NonNull UUID id,
    @NonNull String title,
    boolean isCyber) {

  public NonFunctionalRequirementCommand(UUID id, String title, boolean isCyber) {
    this.id = id;
    this.title = title;
    this.isCyber = isCyber;
  }

  public NonFunctionalRequirementCommand(UUID id) {
    this(id, "", true);
  }

  public NonFunctionalRequirementCommand(String title) {
    this(UUID.randomUUID(), title, true);
  }

  public static NonFunctionalRequirementCommand create(UUID id) {
    return new NonFunctionalRequirementCommand(id);
  }

  public static NonFunctionalRequirementCommand create(UUID id, String title) {
    return new NonFunctionalRequirementCommand(id, title, true);
  }

  public static NonFunctionalRequirementCommand create(UUID id, String title, boolean isCyber) {
    return new NonFunctionalRequirementCommand(id, title, isCyber);
  }
}
