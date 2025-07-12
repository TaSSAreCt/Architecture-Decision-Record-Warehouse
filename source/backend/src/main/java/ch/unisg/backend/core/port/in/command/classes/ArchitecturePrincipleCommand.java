package ch.unisg.backend.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record ArchitecturePrincipleCommand(
        @NonNull UUID id,
        @NonNull String title
        ) {

    public ArchitecturePrincipleCommand(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public ArchitecturePrincipleCommand(
            String title
    ) {
        this(UUID.randomUUID(), title);
    }

    public static ArchitecturePrincipleCommand create(String title) {
        return new ArchitecturePrincipleCommand(title);
    }

    public static ArchitecturePrincipleCommand create(UUID id, String title) {
        return new ArchitecturePrincipleCommand(id, title);
    }
}
