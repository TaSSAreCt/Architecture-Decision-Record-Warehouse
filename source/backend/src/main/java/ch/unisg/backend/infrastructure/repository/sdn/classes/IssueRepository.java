package ch.unisg.backend.infrastructure.repository.sdn.classes;

import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.core.port.out.IssuePort;
import ch.unisg.backend.infrastructure.repository.sdn.api.IssueCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.IssueNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class IssueRepository implements IssuePort {

    private final Neo4jClient client;
    private final IssueCypherPort repository;

    @Override
    public void createIssue(Issue issue) {
        IssueNode entity = new IssueNode();

        entity.setId(issue.getId());
        entity.setTitle(issue.getTitle());

        repository.save(entity);

    }

    @Override
    public Issue getIssueById(Issue issue) {

        Optional<IssueNode> entity = repository.findById(issue.getId());

        entity.ifPresent(issueNode -> issue.setTitle(issueNode.getTitle()));

        return issue;
    }
}
