package ch.unisg.sat.infrastructure.repository.sdn.relationship;

import ch.unisg.sat.infrastructure.repository.sdn.node.AlternativeNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Getter @Setter
public class ForcesRelationship {

    @Id @GeneratedValue
    private String id;

    private double value;

    @TargetNode
    private AlternativeNode target;

    private ForcesRelationship(String id, double value) {
        this.id = id;
        this.value = value;
    }

    public static ForcesRelationship create(String id, double value) {
        return new ForcesRelationship(id, value);
    }
}
