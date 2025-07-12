package ch.unisg.backend.infrastructure.repository.sdn.api;

import ch.unisg.backend.infrastructure.repository.sdn.node.SystemNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.UUID;

public interface SystemCypherPort extends Neo4jRepository<SystemNode, UUID> {

    @Query("""
            MATCH (w:System)
            WHERE NOT EXISTS( (w)-[:PART_OF]->() )
            RETURN w
            """)
    List<SystemNode> findRoot();

    List<SystemNode> findByTitle(String title);
}
