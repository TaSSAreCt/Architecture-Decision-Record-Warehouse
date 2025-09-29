package ch.unisg.backend.infrastructure.repository.sdn.api;

import ch.unisg.backend.infrastructure.repository.sdn.node.RationaleNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface ArchitectureRationaleCypherPort extends Neo4jRepository<RationaleNode, UUID> {
}
