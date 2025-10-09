package ch.unisg.backend.infrastructure.repository.sdn;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.backend.core.port.out.SystemElementPort;
import ch.unisg.backend.infrastructure.repository.sdn.api.SystemElementCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemElementNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SystemElementRepository implements SystemElementPort {

  private final Neo4jClient client;
  private final SystemElementCypherPort repository;

  @Override
  public void createSystemElement(SystemElement systemElement) {
    SystemElementNode systemElementNode = new SystemElementNode(systemElement.getId(), systemElement.getTitle(),
        systemElement.isCyber());
    repository.save(systemElementNode);
  }

  @Override
  public SystemElement findSystemElementById(UUID id) {

    Optional<SystemElementNode> entity = repository.findById(id);

    return entity
        .map(systemElementNode -> SystemElement.create(systemElementNode.getId(), systemElementNode.getTitle(),
            systemElementNode.isCyber()))
        .orElse(null);
  }
}
