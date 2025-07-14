package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.infrastructure.repository.sdn.node.NonFunctionalRequirementNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class NonFunctionalRequirementListMapper {

    public static Collection<NonFunctionalRequirement> toNonFunctionalRequirementList(Set<NonFunctionalRequirementNode> nonFunctionalRequirementNodes) {
        Collection<NonFunctionalRequirement> nonFunctionalRequirements = new ArrayList<>();

        nonFunctionalRequirementNodes.forEach(nonFunctionalRequirementNode -> {
            NonFunctionalRequirement nonFunctionalRequirement = NonFunctionalRequirement.create(nonFunctionalRequirementNode.getId(), nonFunctionalRequirementNode.getTitle());
            nonFunctionalRequirements.add(nonFunctionalRequirement);
        });

        return nonFunctionalRequirements;
    }
}
