package ch.unisg.backend.infrastructure.repository.sdn.node;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Node("Influence")
@Getter
@Setter
public class InfluenceNode {

    @Id
    private UUID id;

    @Property("value")
    private Float value;

    @Relationship(type= "INFLUENCES", direction = Relationship.Direction.INCOMING)
    public List<ConstraintNode> constraintNodeList = new ArrayList<>();

    @Relationship(type= "INFLUENCES", direction = Relationship.Direction.INCOMING)
    public List<IntentionNode> intentionNodeList = new ArrayList<>();

    @Relationship(type= "INFLUENCES", direction = Relationship.Direction.INCOMING)
    public List<ArchitecturePrincipleNode> architecturePrincipleNodeList = new ArrayList<>();

    @Relationship(type= "INFLUENCES", direction = Relationship.Direction.INCOMING)
    public List<NonFunctionalRequirementNode> nonFunctionalRequirementNodeList = new ArrayList<>();

    @Relationship(type = "INFLUENCED_BY", direction = Relationship.Direction.INCOMING)
    public List<AlternativeNode> alternativeNodeList = new ArrayList<>();

    @Relationship(type = "CONSIDERS", direction = Relationship.Direction.INCOMING)
    public List<RationaleNode> rationaleNodeList = new ArrayList<>();

    public InfluenceNode(UUID id, Float value) {
        this.id = id;
        this.value = value;
    }

    public static InfluenceNode create(UUID id, Float value) {
        return new InfluenceNode(id, value);
    }
}
