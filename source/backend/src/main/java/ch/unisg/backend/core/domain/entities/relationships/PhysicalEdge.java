package ch.unisg.backend.core.domain.entities.relationships;

import java.util.UUID;

import ch.qos.logback.core.pattern.parser.Node;

public class PhysicalEdge extends Edge {
  private PhysicalEdge(UUID id, Node startNode, Node endNode) {
    super(id, startNode, endNode);
  }
}
