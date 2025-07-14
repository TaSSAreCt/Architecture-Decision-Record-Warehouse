package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.infrastructure.repository.sdn.node.AlternativeNode;

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
