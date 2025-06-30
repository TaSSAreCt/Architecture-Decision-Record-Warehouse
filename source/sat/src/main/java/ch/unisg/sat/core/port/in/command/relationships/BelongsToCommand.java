package ch.unisg.sat.core.port.in.command.relationships;

import ch.unisg.sat.core.port.in.command.classes.SystemCommand;
import ch.unisg.sat.core.port.in.command.classes.SystemElementCommand;
import lombok.NonNull;

public record BelongsToCommand(
        @NonNull SystemCommand systemCommand,
        @NonNull SystemElementCommand systemElementCommand
        ){

    public BelongsToCommand(
            SystemCommand systemCommand,
            SystemElementCommand systemElementCommand
    ) {
        this.systemCommand = systemCommand;
        this.systemElementCommand = systemElementCommand;
    }

    public static BelongsToCommand create(SystemCommand systemCommand, SystemElementCommand systemElementCommand) {
        return new BelongsToCommand(systemCommand, systemElementCommand);
    }
}
