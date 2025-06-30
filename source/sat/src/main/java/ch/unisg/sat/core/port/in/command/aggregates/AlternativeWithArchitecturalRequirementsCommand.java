package ch.unisg.sat.core.port.in.command.aggregates;

import ch.unisg.sat.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.sat.core.port.in.command.classes.ArchitectureRequirementCommand;
import lombok.NonNull;

public record AlternativeWithArchitecturalRequirementsCommand(
        @NonNull AlternativeCommand alternativeCommand,
        double value,
        @NonNull ArchitectureRequirementCommand[] architecturalRequirementsCommand
) {

    public static AlternativeWithArchitecturalRequirementsCommand create(
            AlternativeCommand alternativeCommand,
            double value,
            ArchitectureRequirementCommand[] architecturalRequirementsCommand
    ) {
        return new AlternativeWithArchitecturalRequirementsCommand(alternativeCommand, value, architecturalRequirementsCommand);
    }
}
