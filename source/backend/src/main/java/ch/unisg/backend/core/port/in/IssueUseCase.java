package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.core.port.in.command.classes.IssueCommand;
import ch.unisg.backend.core.port.in.query.IssueQuery;

public interface IssueUseCase {
    void createIssue(IssueCommand command);
    Issue getIssueById(IssueQuery query);
}
