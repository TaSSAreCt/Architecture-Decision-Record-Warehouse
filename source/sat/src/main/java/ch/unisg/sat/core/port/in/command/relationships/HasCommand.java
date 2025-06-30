package ch.unisg.sat.core.port.in.command.relationships;

import ch.unisg.sat.core.port.in.command.classes.ArchitectureRationaleCommand;
import ch.unisg.sat.core.port.in.command.classes.SystemCommand;
import ch.unisg.sat.core.port.in.command.classes.SystemElementCommand;
import lombok.NonNull;

public record HasCommand(
        @NonNull SystemCommand systemCommand,
        @NonNull ArchitectureRationaleCommand architectureRationaleCommand
        ){

    public HasCommand(
            SystemCommand systemCommand,
            ArchitectureRationaleCommand architectureRationaleCommand
    ) {
        this.systemCommand = systemCommand;
        this.architectureRationaleCommand = architectureRationaleCommand;
    }

    public static HasCommand create(SystemCommand systemCommand, ArchitectureRationaleCommand architectureRationaleCommand) {
        return new HasCommand(systemCommand, architectureRationaleCommand);
    }
}
