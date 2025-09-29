package ch.unisg.backend.core.port.in.command;

import lombok.NonNull;

import java.util.UUID;

public record CreateAlternativeWithIssueCommand(
    @NonNull UUID id,
    @NonNull String title,
    @NonNull UUID issueId
) {

    public static CreateAlternativeWithIssueCommand create(UUID id, String title, UUID issueId) {
        return new CreateAlternativeWithIssueCommand(id, title, issueId);
    }
}
