package ch.unisg.backend.infrastructure.repository.sdn.node;

import ch.unisg.backend.infrastructure.repository.sdn.relationship.InfluenceRelationship;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Node("Intention")
@Getter
@Setter
public class IntentionNode {

    @Id
    private UUID id;

    @Property("title")
    private String title;

    @Relationship(type = "INFLUENCES", direction = Relationship.Direction.OUTGOING)
    public List<InfluenceRelationship> forcesRelationships;

    public IntentionNode(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public static IntentionNode create(UUID id, String title) {
        return new IntentionNode(id, title);
    }

}
