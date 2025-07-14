package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.infrastructure.repository.sdn.node.IssueNode;

public class IssueMapper {

    public static Issue toIssue(IssueNode issueNode) {

        return Issue.create(issueNode.getId(), issueNode.getTitle());
    }

}
