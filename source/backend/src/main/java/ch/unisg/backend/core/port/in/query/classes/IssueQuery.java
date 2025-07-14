package ch.unisg.backend.core.port.in.query.classes;

import lombok.NonNull;

import java.util.UUID;

public record IssueQuery(
        @NonNull UUID id,
        @NonNull String title
        ) {

    public IssueQuery(
            UUID id,
            String title
    ) {
        this.id = id;
        this.title = title;
    }

    public IssueQuery(
            UUID id
    ) {
        this(id, "");
    }
}
