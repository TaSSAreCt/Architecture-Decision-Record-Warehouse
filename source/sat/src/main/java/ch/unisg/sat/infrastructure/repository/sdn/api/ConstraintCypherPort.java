package ch.unisg.sat.infrastructure.repository.sdn.api;

import ch.unisg.sat.infrastructure.repository.sdn.node.ConstraintNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface ConstraintCypherPort extends Neo4jRepository<ConstraintNode, UUID> {
}
