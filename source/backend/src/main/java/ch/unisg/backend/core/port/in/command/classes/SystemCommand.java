package ch.unisg.backend.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record SystemCommand(
    @NonNull UUID id,
    @NonNull String title,
    boolean isCyber) {

  public SystemCommand(UUID id, String title, boolean isCyber) {
    this.id = id;
    this.title = title;
    this.isCyber = isCyber;
  }

  public static SystemCommand create(UUID id, String title, boolean isCyber) {
    return new SystemCommand(id, title, isCyber);
  }

  public static SystemCommand create(UUID id) {
    return new SystemCommand(id, "", false);
  }

  public static SystemCommand create(String title) {
    return new SystemCommand(UUID.randomUUID(), title, false);
  }

}
