package ch.unisg.sat.infrastructure.repository.sdn.node;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Node("Issue")
@Getter @Setter
public class IssueNode {

    @Id
    private UUID id;

    @Property("title")
    private String title;

    public IssueNode() {}

    @Relationship(type = "SOLVED_BY", direction = Relationship.Direction.OUTGOING)
    public Set<AlternativeNode> alternativeNodes = new HashSet<>();


}
