package ch.unisg.backend.core.port.in.query.classes;

import lombok.NonNull;

import java.util.UUID;

public record SystemQuery(
        @NonNull UUID id,
        @NonNull String title
        ) {

    public SystemQuery(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public SystemQuery(
            UUID id
    ) {
        this(id, "");
    }
}
