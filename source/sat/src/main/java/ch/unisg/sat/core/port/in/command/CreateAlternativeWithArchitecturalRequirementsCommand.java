package ch.unisg.sat.core.port.in.command;

import ch.unisg.sat.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.sat.core.port.in.command.classes.ArchitectureRequirementCommand;
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
