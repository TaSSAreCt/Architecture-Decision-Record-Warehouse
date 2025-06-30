package ch.unisg.sat.infrastructure.repository.sdn.api;

import ch.unisg.sat.infrastructure.repository.sdn.node.ArchitectureRationaleNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface ArchitectureRationaleCypherPort extends Neo4jRepository<ArchitectureRationaleNode, UUID> {
}
