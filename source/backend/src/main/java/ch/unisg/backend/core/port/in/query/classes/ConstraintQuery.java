package ch.unisg.backend.core.port.in.query.classes;

import lombok.NonNull;

import java.util.UUID;

public record ConstraintQuery(
        @NonNull UUID id
        ) {

    public ConstraintQuery(UUID id) {
        this.id = id;
    }

    public static ConstraintQuery create(UUID id) {
        return new ConstraintQuery(id);
    }
}
