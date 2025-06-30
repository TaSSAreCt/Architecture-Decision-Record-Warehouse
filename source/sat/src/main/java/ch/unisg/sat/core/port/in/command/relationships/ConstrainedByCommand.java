package ch.unisg.sat.core.port.in.command.relationships;

import ch.unisg.sat.core.port.in.command.classes.ConstraintCommand;
import ch.unisg.sat.core.port.in.command.classes.NonFunctionalRequirementCommand;
import ch.unisg.sat.core.port.in.command.classes.SystemElementCommand;
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
