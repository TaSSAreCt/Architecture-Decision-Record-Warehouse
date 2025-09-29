package ch.unisg.backend.core.port.in.command;

import lombok.NonNull;

import java.util.UUID;

public record CreateSystemElementCommand(
        @NonNull UUID id,
        @NonNull String title,
        @NonNull UUID systemId
) {

    public CreateSystemElementCommand(
            UUID id,
            String title,
            UUID systemId
    ) {
        this.id = id;
        this.title = title;
        this.systemId = systemId;
    }

    public static CreateSystemElementCommand create(UUID id, String title, UUID systemId) {
        return new CreateSystemElementCommand(id, title, systemId);
    }
}
