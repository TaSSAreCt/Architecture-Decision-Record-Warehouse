package ch.unisg.backend.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record ConstraintCommand(
        @NonNull UUID id,
        @NonNull String title
        ) {

    public ConstraintCommand(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public ConstraintCommand(String title) {
        this(UUID.randomUUID(), title);
    }

    public static ConstraintCommand create(UUID id) {
        return new ConstraintCommand(id, "");
    }
    public static ConstraintCommand create(String title) {
        return new ConstraintCommand(UUID.randomUUID(), title);
    }
    public static ConstraintCommand create(UUID id, String title) {
        return new ConstraintCommand(id, title);
    }

}
