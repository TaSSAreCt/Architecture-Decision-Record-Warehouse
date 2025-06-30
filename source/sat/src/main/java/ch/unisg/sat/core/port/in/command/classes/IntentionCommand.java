package ch.unisg.sat.core.port.in.command.classes;

import lombok.NonNull;

import java.util.UUID;

public record IntentionCommand(
        @NonNull UUID id,
        @NonNull String title
) {

    public IntentionCommand(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public IntentionCommand(UUID id) {
        this(id, "");
    }

    public IntentionCommand(String title) {
        this(UUID.randomUUID(), title);
    }


    public static IntentionCommand create(String title) {
        return new IntentionCommand(title);
    }
    public static IntentionCommand create(UUID id, String title) {
        return new IntentionCommand(id, title);
    }
}
