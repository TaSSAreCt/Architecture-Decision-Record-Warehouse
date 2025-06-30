package ch.unisg.sat.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record IssueCommand(
        @NonNull UUID id,
        @NonNull String title
) {
    public IssueCommand(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public static IssueCommand create(UUID id, String title) {
        return new IssueCommand(id, title);
    }
    public static IssueCommand create(String title) {
        return new IssueCommand(UUID.randomUUID(), title);
    }
    public static IssueCommand create(UUID id) {
        return new IssueCommand(id, "");
    }
}
