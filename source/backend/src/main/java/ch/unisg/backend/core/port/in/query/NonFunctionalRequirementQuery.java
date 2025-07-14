package ch.unisg.backend.core.port.in.query;

import lombok.NonNull;

import java.util.UUID;

public record NonFunctionalRequirementQuery(
        @NonNull UUID id
        ) {
    public NonFunctionalRequirementQuery(UUID id) {
        this.id = id;
    }

    public static NonFunctionalRequirementQuery create(UUID id) {
        return new NonFunctionalRequirementQuery(id);
    }

}
