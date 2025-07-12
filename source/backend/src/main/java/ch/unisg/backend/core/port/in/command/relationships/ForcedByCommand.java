package ch.unisg.backend.core.port.in.command.relationships;

import ch.unisg.backend.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.backend.core.port.in.command.classes.ArchitectureRequirementCommand;
import lombok.NonNull;

public record ForcedByCommand(
        double value,
        @NonNull AlternativeCommand alternative,
        @NonNull ArchitectureRequirementCommand architectureRequirement
        ) {

    public ForcedByCommand(
            double value,
            AlternativeCommand alternative,
            ArchitectureRequirementCommand architectureRequirement
            ) {
        this.value = value;
        this.alternative = alternative;
        this.architectureRequirement = architectureRequirement;
    }

    public static ForcedByCommand create(
            double value,
            AlternativeCommand alternative,
            ArchitectureRequirementCommand architectureRequirement
    ) {
        return new ForcedByCommand(value, alternative, architectureRequirement);
    }


}
