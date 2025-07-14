package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.infrastructure.repository.sdn.node.IssueNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class ArchitecturalKnowledgeMapper {

    public static Collection<ArchitectureDecision> toArchitecturalKnowledge(Set<IssueNode> issueNodes) {

        Collection<ArchitectureDecision> architecturalDecisions = new ArrayList<>();

        issueNodes.forEach(issueNode -> {

            ArchitectureDecision architectureDecision = ArchitectureDecision.create();

            architectureDecision.setIssue(IssueMapper.toIssue(issueNode));

            issueNode.alternativeNodes.forEach(alternativeNode -> {

                AlternativeAggregate alternativeAggregate = AlternativeMapper.toAlternativeAggregate(alternativeNode);

                architectureDecision.getAlternativeAggregates().add(alternativeAggregate);

            });

            architecturalDecisions.add(architectureDecision);
        });
        return architecturalDecisions;
    }
}
