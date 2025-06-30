package ch.unisg.sat.infrastructure.repository.sdn.relationship;

import ch.unisg.sat.infrastructure.repository.sdn.node.ArchitectureRequirementNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Getter @Setter
public class ForcedByRelationship {

    @Id @GeneratedValue
    String id;

    private double value;

    @TargetNode
    private ArchitectureRequirementNode target;

    private ForcedByRelationship(String id, double value) {
        this.id = id;
        this.value = value;
    }

    public static ForcedByRelationship create(String id, double value) {
        return new ForcedByRelationship(id, value);
    }
}
