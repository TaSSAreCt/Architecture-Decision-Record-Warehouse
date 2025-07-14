package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ad.Issue;

public interface IssuePort {
    void createIssue(Issue issue);
    Issue getIssueById(Issue issue);
}
