package ch.unisg.backend.infrastructure.repository.sdn.node;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.UUID;

@Node("ArchitectureRationale")
@Getter @Setter
public class RationaleNode {

    @Id
    private UUID id;

    @Property("title")
    private String title;

    @Property("context")
    private String context;

    @Property("decision")
    private String decision;

    @Property("status")
    private String status;

    @Property("Consequences")
    private String consequences;

    @Relationship(type = "JUSTIFIES", direction = Relationship.Direction.OUTGOING)
    private AlternativeNode alternativeNode;

    public RationaleNode(
            UUID id,
            String title,
            String context,
            String decision,
            String status,
            String consequences
    ) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.decision = decision;
        this.status = status;
        this.consequences = consequences;
    }

    public static RationaleNode create(
            UUID id,
            String title,
            String context,
            String decision,
            String status,
            String consequences
    ) {
        return new RationaleNode(id, title, context, decision, status, consequences);
    }
}
