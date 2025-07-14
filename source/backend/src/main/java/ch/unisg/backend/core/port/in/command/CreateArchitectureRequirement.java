package ch.unisg.backend.core.port.in.command;

import lombok.NonNull;

import java.util.UUID;

public record CreateArchitectureRequirement(
        @NonNull UUID id,
        @NonNull String title,
        double value,
        @NonNull String type,
        @NonNull UUID alternativeId
        ) {

    public static CreateArchitectureRequirement create(
            UUID id,
            String title,
            double value,
            String type,
            UUID alternativeId
    ) {
        return new CreateArchitectureRequirement(id, title, value, type, alternativeId);
    }
}
