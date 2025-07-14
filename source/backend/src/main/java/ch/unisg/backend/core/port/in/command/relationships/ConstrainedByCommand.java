package ch.unisg.backend.core.port.in.command.relationships;

import ch.unisg.backend.core.port.in.command.classes.ConstraintCommand;
import ch.unisg.backend.core.port.in.command.classes.SystemElementCommand;
import lombok.NonNull;

public record ConstrainedByCommand(
        @NonNull SystemElementCommand systemElementCommand,
        @NonNull ConstraintCommand constraintCommand
        ) {
    public ConstrainedByCommand(SystemElementCommand systemElementCommand, ConstraintCommand constraintCommand) {
        this.systemElementCommand = systemElementCommand;
        this.constraintCommand = constraintCommand;
    }

    public static ConstrainedByCommand create(SystemElementCommand systemElementCommand, ConstraintCommand constraintCommand) {
        return new ConstrainedByCommand(systemElementCommand, constraintCommand);
    }
}
