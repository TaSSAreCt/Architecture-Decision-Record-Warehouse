package ch.unisg.backend.core.domain.entities.relationships;

import java.util.UUID;
import ch.unisg.backend.core.domain.entities.classes.Node;

public class CyberEdge extends Edge {
  private CyberEdge(UUID id, Node startNode, Node endNode) {
    super(id, startNode, endNode);
  }

  public static CyberEdge create(UUID id, Node startNode, Node endNode) {
    return new CyberEdge(id, startNode, endNode);
  }
}
