package ch.unisg.sat.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record AlternativeCommand(
        @NonNull UUID id,
        @NonNull String title
) {

    public AlternativeCommand(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public static AlternativeCommand create(UUID id, String title) {
        return new AlternativeCommand(id, title);
    }

    public static AlternativeCommand create(UUID id) {
        return new AlternativeCommand(id, "");
    }

    public static AlternativeCommand create(String title) {
        return new AlternativeCommand(UUID.randomUUID(), title);
    }

}
