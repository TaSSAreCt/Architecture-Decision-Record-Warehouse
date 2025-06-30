package ch.unisg.sat.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record NonFunctionalRequirementCommand(
        @NonNull UUID id,
        @NonNull String title
) {

    public NonFunctionalRequirementCommand(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public NonFunctionalRequirementCommand(UUID id) {
        this(id, "");
    }

    public NonFunctionalRequirementCommand(String title) {
        this(UUID.randomUUID(), title);
    }
    public static NonFunctionalRequirementCommand create(UUID id) {
        return new NonFunctionalRequirementCommand(id);
    }

    public static NonFunctionalRequirementCommand create(UUID id, String title) {
        return new NonFunctionalRequirementCommand(id, title);
    }
}
