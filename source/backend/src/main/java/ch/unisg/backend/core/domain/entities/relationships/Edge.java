package ch.unisg.backend.core.domain.entities.relationships;

import java.util.UUID;

import ch.unisg.backend.core.domain.entities.classes.Node;
import lombok.Getter;
import lombok.Setter;

public abstract class Edge {

  @Getter
  protected final UUID id;

  @Getter
  @Setter
  protected Node startNode;
  protected Node endNode;

  protected Edge(UUID id, Node startNode, Node endNode) {
    this.id = id;
    this.startNode = startNode;
    this.endNode = endNode;
  }
}
