package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.domain.entities.classes.ad.Influence;
import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.core.domain.entities.classes.ar.Intention;
import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.infrastructure.repository.sdn.node.InfluenceNode;

import java.util.List;

public class InfluenceMapper {

    public static List<Influence> toInfluenceList(List<InfluenceNode> influenceNodeList) {
        return influenceNodeList.stream().map(InfluenceMapper::toInfluence).toList();
    }

    public static Influence toInfluence(InfluenceNode influenceNode) {

        Alternative alternative = Alternative.create(influenceNode.alternativeNode.getId(), influenceNode.getAlternativeNode().getTitle());

        if (influenceNode.constraintNode != null) {
            Constraint constraint = ConstraintMapper.toConstraint(influenceNode.constraintNode);
            return Influence.create(influenceNode.getId(), influenceNode.getValue(), alternative, constraint);
        }

        if (influenceNode.intentionNode != null) {
            Intention intention = IntentionMapper.toIntention(influenceNode.intentionNode);
            return Influence.create(influenceNode.getId(), influenceNode.getValue(), alternative, intention);
        }

        if (influenceNode.architecturePrincipleNode != null) {
            ArchitecturePrinciple architecturePrinciple = ArchitecturePrincipleMapper.toArchitecturalPrinciple(influenceNode.architecturePrincipleNode);
            return Influence.create(influenceNode.getId(), influenceNode.getValue(), alternative, architecturePrinciple);
        }

        if (influenceNode.nonFunctionalRequirementNode != null) {
            NonFunctionalRequirement nonFunctionalRequirement = NonFunctionalRequirementMapper.toNonFunctionalRequirement(influenceNode.nonFunctionalRequirementNode);
            return Influence.create(influenceNode.getId(), influenceNode.getValue(), alternative, nonFunctionalRequirement);
        }

        return null;
    }

}
