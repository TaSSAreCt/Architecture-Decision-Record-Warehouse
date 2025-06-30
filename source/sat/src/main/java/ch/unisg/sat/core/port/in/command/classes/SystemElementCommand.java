package ch.unisg.sat.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record SystemElementCommand(
        @NonNull UUID id,
        @NonNull String title
        ) {

    public SystemElementCommand(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public static SystemElementCommand create(UUID id, String title) {
        return new SystemElementCommand(id, title);
    }

    public static SystemElementCommand create(UUID id) {
        return new SystemElementCommand(id, "");
    }

    public static SystemElementCommand create(String title) {
        return new SystemElementCommand(UUID.randomUUID(), title);
    }
}
