package ch.unisg.sat.infrastructure.repository.sdn.node;

import ch.unisg.sat.infrastructure.repository.sdn.relationship.ForcesRelationship;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Node("Constraint")
@Getter @Setter
public class ConstraintNode {

    @Id
    private UUID id;

    @Property("title")
    private String title;

    @Relationship(type = "FORCED_BY", direction = Relationship.Direction.INCOMING)
    public Set<ForcesRelationship> forcesRelationships = new HashSet<>();

    public ConstraintNode(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public static ConstraintNode create(UUID id, String title) {
        return new ConstraintNode(id, title);
    }
}
