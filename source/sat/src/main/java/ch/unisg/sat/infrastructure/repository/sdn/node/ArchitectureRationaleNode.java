package ch.unisg.sat.infrastructure.repository.sdn.node;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Node("ArchitectureRationale")
@Getter @Setter
public class ArchitectureRationaleNode {

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

    @Relationship(type = "JUSTIFIED_BY", direction = Relationship.Direction.INCOMING)
    private AlternativeNode alternativeNode;

    public ArchitectureRationaleNode(
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

    public static ArchitectureRationaleNode create(
            UUID id,
            String title,
            String context,
            String decision,
            String status,
            String consequences
    ) {
        return new ArchitectureRationaleNode(id, title, context, decision, status, consequences);
    }
}
