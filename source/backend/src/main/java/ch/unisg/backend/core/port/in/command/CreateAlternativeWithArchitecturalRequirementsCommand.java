package ch.unisg.backend.core.port.in.command;

import ch.unisg.backend.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.backend.core.port.in.command.classes.ArchitectureRequirementCommand;
import lombok.NonNull;

public record CreateAlternativeWithArchitecturalRequirementsCommand(
        @NonNull AlternativeCommand alternativeCommand,
        double value,
        @NonNull ArchitectureRequirementCommand[] architecturalRequirementsCommand
        ) {

    public static CreateAlternativeWithArchitecturalRequirementsCommand create(
            AlternativeCommand alternativeCommand,
            double value,
            ArchitectureRequirementCommand[] architecturalRequirementsCommand
    ) {
        return new CreateAlternativeWithArchitecturalRequirementsCommand(alternativeCommand, value, architecturalRequirementsCommand);
    }
}
