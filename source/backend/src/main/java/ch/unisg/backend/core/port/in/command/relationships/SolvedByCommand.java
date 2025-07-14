package ch.unisg.backend.core.port.in.command.relationships;

import ch.unisg.backend.core.port.in.command.classes.AlternativeCommand;
import ch.unisg.backend.core.port.in.command.classes.IssueCommand;
import lombok.NonNull;

public record SolvedByCommand(
        @NonNull AlternativeCommand alternativeCommand,
        @NonNull IssueCommand issueCommand
        )  {
    public SolvedByCommand(
            AlternativeCommand alternativeCommand,
            IssueCommand issueCommand
    ) {
        this.alternativeCommand = alternativeCommand;
        this.issueCommand = issueCommand;
    }

    public static SolvedByCommand create(
            AlternativeCommand alternativeCommand,
            IssueCommand issueCommand
    ) {
        return new SolvedByCommand(alternativeCommand, issueCommand);
    }
}
