package ch.unisg.backend.infrastructure.repository.sdn.api;

import ch.unisg.backend.infrastructure.repository.sdn.node.AlternativeNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface AlternativeCypherPort extends Neo4jRepository<AlternativeNode, UUID> {
}