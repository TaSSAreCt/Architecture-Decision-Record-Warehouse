package ch.unisg.backend.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record ArchitectureRequirementCommand(
        @NonNull UUID id,
        @NonNull String title,
        @NonNull String type
) {

    public ArchitectureRequirementCommand(
            UUID id,
            String title,
            String type
    ) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public static ArchitectureRequirementCommand create(UUID id, String title, String type) {
        return new ArchitectureRequirementCommand(id, title, type);
    }

    public static ArchitectureRequirementCommand create(UUID id) {
        return new ArchitectureRequirementCommand(id, "", "");
    }
}
