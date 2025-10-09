package ch.unisg.backend.infrastructure.repository.sdn.node;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import jakarta.annotation.Priority;

import java.util.*;

@Node("System")
@Getter
@Setter
public class SystemNode {

  @Id
  private UUID id;

  @Property("title")
  private String title;

  @Property("isCyber")
  private Boolean isCyber;

  @Relationship(type = "PART_OF", direction = Relationship.Direction.INCOMING)
  public List<SystemNode> systemNodes = new ArrayList<>();

  @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
  public List<SystemElementNode> systemElementNodes = new ArrayList<>();

  @Relationship(type = "RAISES", direction = Relationship.Direction.OUTGOING)
  public List<IssueNode> issueNodes = new ArrayList<>();

  @Relationship(type = "REQUIRES", direction = Relationship.Direction.OUTGOING)
  public List<NonFunctionalRequirementNode> nonFunctionalRequirementNodes = new ArrayList<>();

  @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
  public List<RationaleNode> architectureRationaleNodes;

  public SystemNode() {
  }

  public SystemNode(UUID id) {
    this.id = id;
  }

  public SystemNode(UUID id, String title) {
    this.id = id;
    this.title = title;
  }

  public SystemNode(UUID id, String title, Boolean isCyber) {
    this.id = id;
    this.title = title;
    this.isCyber = isCyber;
  }

  public static SystemNode create() {
    return new SystemNode();
  }

  public static SystemNode create(UUID id) {
    return new SystemNode(id);
  }

}
