package ch.unisg.backend.infrastructure.repository.sdn.node;

import ch.unisg.backend.infrastructure.repository.sdn.relationship.InfluenceRelationship;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.*;

@Node("ArchitecturePrinciple")
@Getter @Setter
public class ArchitecturePrincipleNode {

    @Id
    private UUID id;

    @Property("title")
    private String title;

    @Relationship(type = "INFLUENCES", direction = Relationship.Direction.OUTGOING)
    public List<InfluenceRelationship> forcesRelationships;

    public ArchitecturePrincipleNode() {}

    public ArchitecturePrincipleNode(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public ArchitecturePrincipleNode(
            UUID id
    ) {
        this.id = id;
    }

    public static ArchitecturePrincipleNode create(UUID id, String title) {
        return new ArchitecturePrincipleNode(id, title);
    }

    public static ArchitecturePrincipleNode create(UUID id) {
        return new ArchitecturePrincipleNode(id);
    }
}
