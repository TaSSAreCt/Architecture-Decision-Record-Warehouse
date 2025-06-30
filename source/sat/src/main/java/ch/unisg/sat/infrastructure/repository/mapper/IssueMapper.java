package ch.unisg.sat.infrastructure.repository.mapper;

import ch.unisg.sat.core.domain.entities.classes.ad.Issue;
import ch.unisg.sat.infrastructure.repository.sdn.node.IssueNode;

public class IssueMapper {

    public static Issue toIssue(IssueNode issueNode) {

        return Issue.create(issueNode.getId(), issueNode.getTitle());
    }

}
