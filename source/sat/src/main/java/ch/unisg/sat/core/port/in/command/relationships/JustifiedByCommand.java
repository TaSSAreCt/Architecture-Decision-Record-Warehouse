package ch.unisg.sat.core.port.in.command.relationships;

import ch.unisg.sat.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.sat.core.port.in.command.classes.ArchitectureRationaleCommand;
import lombok.NonNull;

import java.util.UUID;

public record JustifiedByCommand(
        @NonNull UUID id,
        @NonNull AlternativeCommand alternative,
        @NonNull ArchitectureRationaleCommand architectureRationale
) {
    public JustifiedByCommand(
            UUID id,
            AlternativeCommand alternative,
            ArchitectureRationaleCommand architectureRationale
    ) {
        this.id = id;
        this.alternative = alternative;
        this.architectureRationale = architectureRationale;
    }

    public static JustifiedByCommand create(
            AlternativeCommand alternative,
            ArchitectureRationaleCommand architectureRationale
    ) {
        return new JustifiedByCommand(UUID.randomUUID(), alternative, architectureRationale);
    }
}
