package ch.unisg.backend.infrastructure.repository.sdn;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.core.port.out.NonFunctionalRequirementPort;
import ch.unisg.backend.infrastructure.repository.sdn.api.NonFunctionalRequirementCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.NonFunctionalRequirementNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class NonFunctionalRequirementRepository implements NonFunctionalRequirementPort {

  private final NonFunctionalRequirementCypherPort repository;

  @Override
  public void create(NonFunctionalRequirement nonFunctionalRequirement) {
    repository.save(
        NonFunctionalRequirementNode.create(nonFunctionalRequirement.getId(), nonFunctionalRequirement.getTitle(),
            nonFunctionalRequirement.isCyber()));
  }

  @Override
  public NonFunctionalRequirement findById(UUID id) {

    Optional<NonFunctionalRequirementNode> entity = repository.findById(id);

    return entity
        .map(nonFunctionalRequirementNode -> NonFunctionalRequirement.create(nonFunctionalRequirementNode.getId(),
            nonFunctionalRequirementNode.getTitle(), nonFunctionalRequirementNode.isCyber()))
        .orElse(null);
  }

  @Override
  public void readAll(List<NonFunctionalRequirement> nonFunctionalRequirementList) {
    List<NonFunctionalRequirementNode> nonFunctionalRequirementNodeList = repository.findAll();

    for (NonFunctionalRequirementNode nonFunctionalRequirementNode : nonFunctionalRequirementNodeList) {
      nonFunctionalRequirementList.add(NonFunctionalRequirement.create(nonFunctionalRequirementNode.getId(),
          nonFunctionalRequirementNode.getTitle(), nonFunctionalRequirementNode.isCyber()));
    }
  }
}
