package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.infrastructure.repository.sdn.node.IssueNode;

import java.util.List;
import java.util.Set;

public class IssueMapper {

    public static Issue toIssue(IssueNode issueNode) {

        Issue issue = Issue.create(issueNode.getId(), issueNode.getTitle());
        issue.getAlternativeList().addAll(AlternativeMapper.toAlternativeList(issueNode.alternativeNodes));

        return issue;
    }

    public static List<Issue> toIssueList(List<IssueNode> issueNodeList) {
        return issueNodeList.stream().map(IssueMapper::toIssue).toList();
    }

}
