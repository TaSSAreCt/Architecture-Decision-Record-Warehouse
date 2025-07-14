package ch.unisg.backend.infrastructure.repository.sdn.relationship;

import ch.unisg.backend.infrastructure.repository.sdn.node.AlternativeNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Getter @Setter
public class InfluenceRelationship {

    @Id @GeneratedValue
    private String id;

    private double value;

    @TargetNode
    private AlternativeNode target;

    private InfluenceRelationship(String id, double value) {
        this.id = id;
        this.value = value;
    }

    public static InfluenceRelationship create(String id, double value) {
        return new InfluenceRelationship(id, value);
    }
}
