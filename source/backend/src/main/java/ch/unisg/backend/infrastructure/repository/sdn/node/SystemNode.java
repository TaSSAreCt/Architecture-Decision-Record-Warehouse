package ch.unisg.backend.infrastructure.repository.sdn.node;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Node("System")
@Getter @Setter
public class SystemNode {

    @Id
    private UUID id;

    @Property("title")
    private String title;

    @Relationship(type = "PART_OF", direction = Relationship.Direction.INCOMING)
    public Set<SystemNode> systemNodes = new HashSet<>();

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    public Set<SystemElementNode> systemElementNodes = new HashSet<>();

    @Relationship(type = "RAISES", direction = Relationship.Direction.OUTGOING)
    public Set<IssueNode> issueNodes = new HashSet<>();

    @Relationship(type = "REQUIRES", direction = Relationship.Direction.OUTGOING)
    public Set<NonFunctionalRequirementNode> nonFunctionalRequirementNodes = new HashSet<>();

    @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
    public Set<RationaleNode> architectureRationaleNodes;

    public SystemNode() {}
    public SystemNode(UUID id) {
        this.id = id;
    }
    public SystemNode(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public static SystemNode create() {
        return new SystemNode();
    }
    public static SystemNode create(UUID id) {
        return new SystemNode(id);
    }

}
