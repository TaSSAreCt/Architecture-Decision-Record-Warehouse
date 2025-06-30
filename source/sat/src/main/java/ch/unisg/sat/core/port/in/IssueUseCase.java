package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.domain.entities.classes.ad.Issue;
import ch.unisg.sat.core.port.in.command.classes.IssueCommand;
import ch.unisg.sat.core.port.in.query.classes.IssueQuery;

public interface IssueUseCase {
    void createIssue(IssueCommand command);
    Issue getIssueById(IssueQuery query);
}
