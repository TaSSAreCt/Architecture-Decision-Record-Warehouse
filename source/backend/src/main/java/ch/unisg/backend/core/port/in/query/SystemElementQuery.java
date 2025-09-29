package ch.unisg.backend.core.port.in.query;

import lombok.NonNull;

import java.util.UUID;

public record SystemElementQuery(
        @NonNull UUID id,
        @NonNull String title
        ) {

    public SystemElementQuery(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public SystemElementQuery(
            UUID id
    ) {
        this(id, "");
    }
}
