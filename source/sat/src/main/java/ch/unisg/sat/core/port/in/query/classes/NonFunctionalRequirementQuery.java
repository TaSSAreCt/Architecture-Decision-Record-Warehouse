package ch.unisg.sat.core.port.in.query.classes;

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
