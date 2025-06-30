package ch.unisg.sat.core.port.in.query.classes;

import lombok.NonNull;

import java.util.UUID;

public record ArchitecturePrincipleQuery(
        @NonNull UUID id
        ) {

    public ArchitecturePrincipleQuery(UUID id) {
        this.id = id;
    }

    public static ArchitecturePrincipleQuery create(UUID id) {
        return new ArchitecturePrincipleQuery(id);
    }
}
