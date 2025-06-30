package ch.unisg.sat.infrastructure.repository.sdn.api;

import ch.unisg.sat.infrastructure.repository.sdn.node.IssueNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface IssueCypherPort extends Neo4jRepository<IssueNode, UUID> {
}
