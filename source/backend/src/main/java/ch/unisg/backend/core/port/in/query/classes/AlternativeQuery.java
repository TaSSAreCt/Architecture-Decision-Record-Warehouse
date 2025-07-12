package ch.unisg.backend.core.port.in.query.classes;

import lombok.NonNull;

import java.util.UUID;

public record AlternativeQuery(
        @NonNull UUID id,
        @NonNull String title
        ) {
    public AlternativeQuery(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public AlternativeQuery(
            UUID id
    ) {
        this(id, "");
    }

    public AlternativeQuery(
            String title
    ) {
        this(UUID.randomUUID(), title);
    }
}
