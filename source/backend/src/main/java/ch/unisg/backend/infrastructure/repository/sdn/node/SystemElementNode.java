package ch.unisg.backend.infrastructure.repository.sdn.node;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Node("SystemElement")
@Getter @Setter
public class SystemElementNode {

    @Id
    private UUID id;

    @Property("title")
    private String title;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    public Set<SystemNode> systemNodes = new HashSet<>();

    @Relationship(type = "CONSTRAINED_BY",direction = Relationship.Direction.OUTGOING)
    public Set<ConstraintNode> constraintNodes = new HashSet<>();

    public SystemElementNode(UUID id, String title) {
        this.id = id;
        this.title = title;
    }
}
