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

    @Relationship(type = "INFLUENCES", direction = Relationship.Direction.INCOMING)
    private List<ConstraintNode> constraintNodes;

    @Relationship(type = "INFLUENCES", direction = Relationship.Direction.INCOMING)
    private List<IntentionNode> intentionNodes;

    @Relationship(type = "INFLUENCES", direction = Relationship.Direction.INCOMING)
    private List<ArchitecturePrincipleNode> architecturePrincipleNodes;

    @Relationship(type = "INFLUENCES", direction = Relationship.Direction.INCOMING)
    private List<NonFunctionalRequirementNode> nonFunctionalRequirementNodes;

    @Relationship(type = "INFLUENCES", direction = Relationship.Direction.INCOMING)
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
