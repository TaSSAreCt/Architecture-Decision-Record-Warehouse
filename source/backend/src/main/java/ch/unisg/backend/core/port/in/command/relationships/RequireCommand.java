package ch.unisg.backend.core.port.in.command.relationships;

import ch.unisg.backend.core.port.in.command.classes.NonFunctionalRequirementCommand;
import ch.unisg.backend.core.port.in.command.classes.SystemCommand;
import lombok.NonNull;

public record RequireCommand(
        @NonNull SystemCommand systemClassCommand,
        @NonNull NonFunctionalRequirementCommand nonFunctionalRequirementCommand
        ) {

    public RequireCommand(SystemCommand systemClassCommand, NonFunctionalRequirementCommand nonFunctionalRequirementCommand) {
        this.systemClassCommand = systemClassCommand;
        this.nonFunctionalRequirementCommand = nonFunctionalRequirementCommand;
    }

    public static RequireCommand create(SystemCommand systemClassCommand, NonFunctionalRequirementCommand nonFunctionalRequirementCommand) {
        return new RequireCommand(systemClassCommand, nonFunctionalRequirementCommand);
    }
}
