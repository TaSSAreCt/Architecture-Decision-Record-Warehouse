package ch.unisg.backend.core.port.in.command;

import lombok.NonNull;

import java.util.UUID;

public record CreateInfluenceCommand(
        @NonNull UUID id,
        @NonNull Float value,
        @NonNull UUID alternativeId,
        @NonNull UUID architectureRequirementId
        ) {

    public CreateInfluenceCommand(
            UUID id,
            Float value,
            UUID alternativeId,
            UUID architectureRequirementId
    ) {
        this.id = id;
        this.value = value;
        this.alternativeId = alternativeId;
        this.architectureRequirementId = architectureRequirementId;
    }
}
