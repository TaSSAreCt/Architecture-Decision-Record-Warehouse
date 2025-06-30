package ch.unisg.sat.infrastructure.repository.mapper;

import ch.unisg.sat.core.domain.aggregate.AlternativeAggregate;
import ch.unisg.sat.core.domain.aggregate.ArchitectureDecision;
import ch.unisg.sat.core.domain.aggregate.ForcedBy;
import ch.unisg.sat.infrastructure.repository.mapper.ad.ArchitectureRationaleMapper;
import ch.unisg.sat.infrastructure.repository.mapper.ar.ConstraintMapper;
import ch.unisg.sat.infrastructure.repository.mapper.ar.NonFunctionalRequirementMapper;
import ch.unisg.sat.infrastructure.repository.sdn.node.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ArchitecturalDecisionListMapper {

    public static Collection<ArchitectureDecision> toArchitecturalDecisionList(SystemNode systemNode) {

        Collection<ArchitectureDecision> architecturalDecisions = new ArrayList<>();

        systemNode.issueNodes.forEach(issueNode -> {

            ArchitectureDecision architectureDecision = ArchitectureDecision.create();
            architectureDecision.setIssue(IssueMapper.toIssue(issueNode));

            issueNode.alternativeNodes.forEach(alternativeNode -> {

                AlternativeAggregate alternativeAggregate = AlternativeMapper.toAlternativeAggregate(alternativeNode);

                List<NonFunctionalRequirementNode> nonFunctionalRequirementNodes = alternativeNode.getNonFunctionalRequirementNodes().stream()
                        .filter(alternativeNonFunctionalRequirementNode -> systemNode.nonFunctionalRequirementNodes.stream()
                                .anyMatch(systemNonFunctionalRequirement -> systemNonFunctionalRequirement.getId().equals(alternativeNonFunctionalRequirementNode.getId())))
                        .toList();

                nonFunctionalRequirementNodes.forEach(nonFunctionalRequirementNode -> {
                    nonFunctionalRequirementNode.forcesRelationships.forEach(forcesRelationship -> {
                        if (forcesRelationship.getTarget().getId().equals(alternativeNode.getId())) {
                            alternativeAggregate.getForcedBy().add(ForcedBy.create(NonFunctionalRequirementMapper.toNonFunctionalRequirement(nonFunctionalRequirementNode), forcesRelationship.getValue()));
                        }
                    });
                });

                List<ConstraintNode> matchingConstraintNodes = alternativeNode.getConstraintNodes().stream()
                        .filter(alternativeConstraintNode -> systemNode.systemElementNodes.stream()
                                .flatMap(systemElementNode -> systemElementNode.getConstraintNodes().stream())
                                .anyMatch(systemElementConstraintNode -> systemElementConstraintNode.getId().equals(alternativeConstraintNode.getId())))
                        .toList();

                matchingConstraintNodes.forEach(constraintNode -> {
                    constraintNode.getForcesRelationships().forEach(forcesRelationship -> {
                        if (forcesRelationship.getTarget().getId().equals(alternativeNode.getId())) {
                            alternativeAggregate.getForcedBy().add(
                                    ForcedBy.create(
                                            ConstraintMapper.toConstraint(constraintNode),
                                            forcesRelationship.getValue()
                                    )
                            );
                        }
                    });
                });

                List<ArchitectureRationaleNode> matchedArchitecturalRationales = systemNode.getArchitectureRationaleNodes().stream()
                        .filter(architectureRationaleNode -> architectureRationaleNode.getAlternativeNode().getId().equals(alternativeAggregate.getAlternative().getId()))
                        .toList();

                matchedArchitecturalRationales.forEach(architectureRationaleNode -> {
                    alternativeAggregate.getArchitectureRationales().add(ArchitectureRationaleMapper.toArchitectureRationale(architectureRationaleNode));
                });

                architectureDecision.getAlternativeAggregates().add(alternativeAggregate);
            });

            architecturalDecisions.add(architectureDecision);

        });

        return architecturalDecisions;
    }

}
