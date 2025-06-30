package ch.unisg.sat.infrastructure.repository.mapper;

import ch.unisg.sat.core.domain.aggregate.AlternativeAggregate;
import ch.unisg.sat.core.domain.aggregate.ForcedBy;
import ch.unisg.sat.infrastructure.repository.mapper.ad.ArchitectureRationaleMapper;
import ch.unisg.sat.infrastructure.repository.mapper.ar.ArchitecturalPrincipleMapper;
import ch.unisg.sat.infrastructure.repository.mapper.ar.ConstraintMapper;
import ch.unisg.sat.infrastructure.repository.mapper.ar.IntentionMapper;
import ch.unisg.sat.infrastructure.repository.mapper.ar.NonFunctionalRequirementMapper;
import ch.unisg.sat.infrastructure.repository.sdn.node.AlternativeNode;

public class AlternativeMapper {
    public static AlternativeAggregate toAlternativeAggregate(AlternativeNode alternativeNode) {

        AlternativeAggregate alternativeAggregate = AlternativeAggregate.create(alternativeNode.getId(), alternativeNode.getTitle());

        alternativeNode.getIntentionNodes().forEach(intentionNode -> {
            intentionNode.forcesRelationships.forEach(forcesRelationship -> {
                if (forcesRelationship.getTarget().getId() == alternativeNode.getId()) {
                    alternativeAggregate.getForcedBy().add(ForcedBy.create(IntentionMapper.toIntention(intentionNode), forcesRelationship.getValue()));
                }
            });

        });

        alternativeNode.getNonFunctionalRequirementNodes().forEach(nonFunctionalRequirementNode -> {
            nonFunctionalRequirementNode.forcesRelationships.forEach(forcesRelationship -> {
                if (forcesRelationship.getTarget().getId() == alternativeNode.getId()) {
                    alternativeAggregate.getForcedBy().add(ForcedBy.create(NonFunctionalRequirementMapper.toNonFunctionalRequirement(nonFunctionalRequirementNode), forcesRelationship.getValue()));
                }
            });
        });

        alternativeNode.getConstraintNodes().forEach(constraintNode -> {
            constraintNode.forcesRelationships.forEach(forcesRelationship -> {
                if (forcesRelationship.getTarget().getId() == alternativeNode.getId()) {
                    alternativeAggregate.getForcedBy().add(ForcedBy.create(ConstraintMapper.toConstraint(constraintNode), forcesRelationship.getValue()));
                }
            });
        });

        alternativeNode.getArchitecturePrincipleNodes().forEach(architecturePrincipleNode -> {
            architecturePrincipleNode.forcesRelationships.forEach(forcesRelationship -> {
                if (forcesRelationship.getTarget().getId() == alternativeNode.getId()) {
                    alternativeAggregate.getForcedBy().add(ForcedBy.create(ArchitecturalPrincipleMapper.toArchitecturalPrinciple(architecturePrincipleNode), forcesRelationship.getValue()));
                }
            });
        });

        return alternativeAggregate;
    }
}
