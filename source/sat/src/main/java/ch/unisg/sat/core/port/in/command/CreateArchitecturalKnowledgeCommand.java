package ch.unisg.sat.core.port.in.command;

import ch.unisg.sat.core.port.in.command.aggregates.AlternativeWithArchitecturalRequirementsCommand;
import ch.unisg.sat.core.port.in.command.classes.IssueCommand;
import lombok.NonNull;

public record CreateArchitecturalKnowledgeCommand(
        @NonNull IssueCommand issueCommand,
        @NonNull AlternativeWithArchitecturalRequirementsCommand alternativeCommand
        ) {
    public CreateArchitecturalKnowledgeCommand(
            IssueCommand issueCommand,
            AlternativeWithArchitecturalRequirementsCommand alternativeCommand
    ) {
        this.issueCommand = issueCommand;
        this.alternativeCommand = alternativeCommand;
    }

    public static CreateArchitecturalKnowledgeCommand create(
            IssueCommand issueCommand,
            AlternativeWithArchitecturalRequirementsCommand alternativeCommand
    )  {
        return new CreateArchitecturalKnowledgeCommand(issueCommand, alternativeCommand);
    }

}
