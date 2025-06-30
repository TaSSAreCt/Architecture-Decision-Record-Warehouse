package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.entities.classes.ad.Issue;

public interface IssuePort {
    void createIssue(Issue issue);
    Issue getIssueById(Issue issue);
}
