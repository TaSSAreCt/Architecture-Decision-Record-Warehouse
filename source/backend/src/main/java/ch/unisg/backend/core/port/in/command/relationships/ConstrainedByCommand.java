package ch.unisg.backend.core.port.in.command.relationships;

import ch.unisg.backend.core.port.in.command.classes.ConstraintCommand;
import ch.unisg.backend.core.port.in.command.classes.SystemElementCommand;
import lombok.NonNull;

public record ConstrainedByCommand(
    @NonNull SystemElementCommand systemElementCommand,
    @NonNull ConstraintCommand constraintCommand,
    boolean isCyber

) {
  public ConstrainedByCommand(SystemElementCommand systemElementCommand, ConstraintCommand constraintCommand,
      boolean isCyber) {
    this.systemElementCommand = systemElementCommand;
    this.constraintCommand = constraintCommand;
    this.isCyber = isCyber;
  }

  public static ConstrainedByCommand create(
      SystemElementCommand systemElementCommand,
      ConstraintCommand constraintCommand,
      boolean isCyber) {
    return new ConstrainedByCommand(
        systemElementCommand,
        constraintCommand,
        isCyber);
  }
}
