package ch.unisg.backend.infrastructure.repository.sdn.node;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.UUID;

@Node("Alternatives")
@Getter
@Setter
public class AlternativeNode {

    @Id
    private UUID id;

    @Property("title")
    private String title;

    @Property("isSelected")
    private Boolean isSelected;

    @Relationship(type = "FORCED_BY", direction = Relationship.Direction.OUTGOING)
    private List<ConstraintNode> constraintNodes;

    @Relationship(type = "FORCED_BY", direction = Relationship.Direction.OUTGOING)
    private List<IntentionNode> intentionNodes;

    @Relationship(type = "FORCED_BY", direction = Relationship.Direction.OUTGOING)
    private List<ArchitecturePrincipleNode> architecturePrincipleNodes;

    @Relationship(type = "FORCED_BY", direction = Relationship.Direction.OUTGOING)
    private List<NonFunctionalRequirementNode> nonFunctionalRequirementNodes;

    @Relationship(type = "SOLVED_BY", direction = Relationship.Direction.INCOMING)
    public List<IssueNode> issues;

    public AlternativeNode(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public static AlternativeNode create(UUID id, String title) {
        return new AlternativeNode(id, title);
    }

    public static AlternativeNode create() {
        return new AlternativeNode(null, null);
    }
}
