package ch.unisg.sat.core.port.in.query.classes;

import lombok.NonNull;

import java.util.UUID;

public record ArchitectureRationaleQuery(
        @NonNull UUID id,
        @NonNull String title
        ) {

    public ArchitectureRationaleQuery(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public ArchitectureRationaleQuery(UUID id) {
        this(id, "");
    }
}
