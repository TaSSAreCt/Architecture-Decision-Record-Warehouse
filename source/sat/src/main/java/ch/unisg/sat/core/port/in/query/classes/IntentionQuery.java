package ch.unisg.sat.core.port.in.query.classes;

import lombok.NonNull;

import java.util.UUID;

public record IntentionQuery(
        @NonNull UUID id,
        @NonNull String title
        ) {

    public IntentionQuery(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public IntentionQuery(
            UUID id
    ) {
        this(id, "");
    }

    public IntentionQuery(
            String title
    ) {
        this(UUID.randomUUID(), title);
    }

    public static IntentionQuery create(UUID id) {
        return new IntentionQuery(id);
    }
}
