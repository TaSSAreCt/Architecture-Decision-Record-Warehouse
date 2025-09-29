package ch.unisg.backend.core.port.in.command;

import lombok.NonNull;

import java.util.UUID;

public record CreateArchitectureRequirement(
        @NonNull UUID id,
        @NonNull String title,
        @NonNull String type
        ) {

    public static CreateArchitectureRequirement create(
            UUID id,
            String title,
            String type
    ) {
        return new CreateArchitectureRequirement(id, title, type);
    }
}
