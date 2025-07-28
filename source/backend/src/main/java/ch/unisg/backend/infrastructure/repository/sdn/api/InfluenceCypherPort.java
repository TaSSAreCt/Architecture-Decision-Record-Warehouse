package ch.unisg.backend.infrastructure.repository.sdn.api;

import ch.unisg.backend.infrastructure.repository.sdn.node.InfluenceNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface InfluenceCypherPort extends Neo4jRepository<InfluenceNode, UUID> {
}
