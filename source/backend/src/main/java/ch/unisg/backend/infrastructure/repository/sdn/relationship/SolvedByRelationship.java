package ch.unisg.backend.infrastructure.repository.sdn.relationship;

import ch.unisg.backend.infrastructure.repository.sdn.node.AlternativeNode;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class SolvedByRelationship {

    @Id @GeneratedValue
    String id;

    @TargetNode
    AlternativeNode alternativeNode;
}
