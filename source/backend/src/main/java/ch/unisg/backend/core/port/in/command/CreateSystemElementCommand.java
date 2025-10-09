package ch.unisg.backend.core.port.in.command;

import lombok.NonNull;

import java.util.UUID;

public record CreateSystemElementCommand(
    @NonNull UUID id,
    @NonNull String title,
    boolean isCyber,
    @NonNull UUID systemId) {

  public CreateSystemElementCommand(
      UUID id,
      String title,
      boolean isCyber,
      UUID systemId) {
    this.id = id;
    this.title = title;
    this.systemId = systemId;
    this.isCyber = isCyber;
  }

  public static CreateSystemElementCommand create(UUID id, String title, boolean isCyber, UUID systemId) {
    return new CreateSystemElementCommand(id, title, isCyber, systemId);
  }
}
