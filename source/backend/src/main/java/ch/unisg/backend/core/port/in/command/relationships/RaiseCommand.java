package ch.unisg.backend.core.port.in.command.relationships;

import ch.unisg.backend.core.port.in.command.classes.IssueCommand;
import ch.unisg.backend.core.port.in.command.classes.SystemCommand;
import lombok.NonNull;

public record RaiseCommand(
        @NonNull IssueCommand issueCommand,
        @NonNull SystemCommand systemCommand
        ) {

    public RaiseCommand(
            IssueCommand issueCommand,
            SystemCommand systemCommand
    ) {
        this.issueCommand = issueCommand;
        this.systemCommand = systemCommand;
    }

    public static RaiseCommand create(IssueCommand issueCommand, SystemCommand systemCommand) {
        return new RaiseCommand(issueCommand, systemCommand);
    }

}
