package ch.unisg.backend.infrastructure.repository.mapper.ar;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.infrastructure.repository.sdn.node.NonFunctionalRequirementNode;

public class NonFunctionalRequirementMapper {

    public static NonFunctionalRequirement toNonFunctionalRequirement(NonFunctionalRequirementNode nonFunctionalRequirementNode) {
        return NonFunctionalRequirement.create(nonFunctionalRequirementNode.getId(), nonFunctionalRequirementNode.getTitle());
    }
}
