package ch.unisg.backend.infrastructure.repository.sdn.node;

import ch.unisg.backend.infrastructure.repository.sdn.relationship.InfluenceRelationship;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Node("NonFunctionalRequirement")
@Getter
@Setter
public class NonFunctionalRequirementNode {

  @Id
  private UUID id;

  @Property("title")
  private String title;

  @Property("isCyber")
  private boolean isCyber;

  @Relationship(type = "INFLUENCES", direction = Relationship.Direction.OUTGOING)
  public List<InfluenceRelationship> forcesRelationships;

  public NonFunctionalRequirementNode(UUID id, String title, boolean isCyber) {
    this.id = id;
    this.title = title;
    this.isCyber = isCyber;
  }

  public static NonFunctionalRequirementNode create(UUID id, String title, boolean isCyber) {
    return new NonFunctionalRequirementNode(id, title, isCyber);
  }

}
