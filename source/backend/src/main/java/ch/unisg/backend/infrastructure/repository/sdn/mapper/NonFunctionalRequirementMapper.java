package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.infrastructure.repository.sdn.node.NonFunctionalRequirementNode;

import java.util.List;
import java.util.Set;

public class NonFunctionalRequirementMapper {

  public static NonFunctionalRequirement toNonFunctionalRequirement(
      NonFunctionalRequirementNode nonFunctionalRequirementNode) {
    return NonFunctionalRequirement.create(nonFunctionalRequirementNode.getId(),
        nonFunctionalRequirementNode.getTitle(), nonFunctionalRequirementNode.isCyber());
  }

  public static List<NonFunctionalRequirement> toNonFunctionalRequirementList(
      List<NonFunctionalRequirementNode> nonFunctionalRequirementNodeList) {
    return nonFunctionalRequirementNodeList.stream().map(NonFunctionalRequirementMapper::toNonFunctionalRequirement)
        .toList();
  }
}
