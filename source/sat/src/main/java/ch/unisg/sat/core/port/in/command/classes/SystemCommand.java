package ch.unisg.sat.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record SystemCommand(
        @NonNull UUID id,
        @NonNull String title
        ) {

    public SystemCommand(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public static SystemCommand create(UUID id, String title) {
        return new SystemCommand(id, title);
    }

    public static SystemCommand create(UUID id) {
        return new SystemCommand(id, "");
    }

    public static SystemCommand create(String title) {
        return new SystemCommand(UUID.randomUUID(), title);
    }

}
