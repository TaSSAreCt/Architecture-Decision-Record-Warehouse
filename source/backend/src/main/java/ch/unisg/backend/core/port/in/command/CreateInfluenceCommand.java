package ch.unisg.backend.core.port.in.command;

import lombok.NonNull;

import java.util.UUID;

public record CreateInfluenceCommand(
        @NonNull UUID id,
        @NonNull UUID alternativeId,
        @NonNull UUID architectureRequirementId
        ) {

    public CreateInfluenceCommand(
            UUID id,
            UUID alternativeId,
            UUID architectureRequirementId
    ) {
        this.id = id;
        this.alternativeId = alternativeId;
        this.architectureRequirementId = architectureRequirementId;
    }
}
