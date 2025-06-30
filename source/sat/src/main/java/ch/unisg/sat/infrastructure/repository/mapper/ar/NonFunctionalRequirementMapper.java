package ch.unisg.sat.infrastructure.repository.mapper.ar;

import ch.unisg.sat.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.sat.infrastructure.repository.sdn.node.NonFunctionalRequirementNode;

public class NonFunctionalRequirementMapper {

    public static NonFunctionalRequirement toNonFunctionalRequirement(NonFunctionalRequirementNode nonFunctionalRequirementNode) {
        return NonFunctionalRequirement.create(nonFunctionalRequirementNode.getId(), nonFunctionalRequirementNode.getTitle());
    }
}
