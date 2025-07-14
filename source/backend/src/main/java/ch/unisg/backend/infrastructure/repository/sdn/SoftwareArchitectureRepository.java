package ch.unisg.backend.infrastructure.repository.sdn;

import ch.unisg.backend.core.domain.aggregate.*;
import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.backend.core.port.out.SoftwareArchitecturePort;
import ch.unisg.backend.infrastructure.repository.sdn.mapper.ArchitecturalDecisionListMapper;
import ch.unisg.backend.infrastructure.repository.sdn.mapper.ArchitecturalKnowledgeMapper;
import ch.unisg.backend.infrastructure.repository.sdn.mapper.SystemMapper;
import ch.unisg.backend.infrastructure.repository.sdn.mapper.NonFunctionalRequirementListMapper;
import ch.unisg.backend.infrastructure.repository.sdn.api.ArchitectureRationaleCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.api.IssueCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.api.SystemCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 *
 */
@RequiredArgsConstructor
@Component
public class SoftwareArchitectureRepository implements SoftwareArchitecturePort {

    private final SystemCypherPort repository;
    private final IssueCypherPort issueRepository;
    private final ArchitectureRationaleCypherPort architectureRationaleRepository;

    @Override
    public void getArchitecturalKnowledge(ArchitecturalKnowledge architecturalKnowledge) {

        Set<IssueNode> issueNodes = new HashSet<>(issueRepository.findAll());

        Collection<ArchitectureDecision> architecturalDecisions = ArchitecturalKnowledgeMapper.toArchitecturalKnowledge(issueNodes);

        architecturalKnowledge.getArchitectureDecisions().addAll(architecturalDecisions);

    }

    /**
     *
     */
    @Override
    public  void getArchitecturalDecisions(ArchitecturalDecisions architecturalDecisions) {

        List<IssueNode> issueNodeList = issueRepository.findAll();

        issueNodeList.forEach(issueNode -> {

            ArchitectureDecision architectureDecision = ArchitectureDecision.create();

            architectureDecision.getIssue().setId(issueNode.getId());
            architectureDecision.getIssue().setTitle(issueNode.getTitle());

            for (AlternativeNode alternativeNode : issueNode.alternativeNodes) {

                architectureDecision.getAlternativeAggregates().add(
                        AlternativeAggregate.create(
                                alternativeNode.getId(),
                                alternativeNode.getTitle()
                        )
                );

            }

            architecturalDecisions.getValue().add(architectureDecision);


        });
    }

    /**
     *
     *
     */
    @Override
    public void getSystemsOfSystems(List<SystemOfSystems> systemsOfSystems) {

        List<SystemNode> systemNodes = repository.findRoot();

        systemNodes.forEach(systemNode -> {
            SystemOfSystems systemOfSystems = SystemOfSystems.create();

            systemOfSystems.setSystemClass(SystemMapper.toSystem(systemNode));

            Optional<SystemNode> nodes = repository.findById(systemNode.getId());
            nodes.ifPresent(node -> {
                traverseSystem(node, systemOfSystems);
            });

            systemsOfSystems.add(systemOfSystems);
        });

    }

    /**
     *
     *
     */
    @Override
    public void getSoftwareArchitecture(ArchitectureDecisionRecordWarehouse softwareArchitecture) {

        // find all root nodes
        List<SystemNode> rootNodes = repository.findRoot();

        // iterate of the root nodes
        rootNodes.forEach(rootNode -> {

            // create a system of systems
            SystemOfSystems systemOfSystems = SystemOfSystems.create();

            // initialize the base system of the system of systems
            systemOfSystems.setSystemClass(SystemMapper.toSystem(rootNode));

            // find the system node of root nodes
            Optional<SystemNode> systemNodes = repository.findById(rootNode.getId());
            systemNodes.ifPresent(systemNode -> {

                // add architectural decisions
                systemOfSystems.getArchitecturalDecisions().addAll(ArchitecturalDecisionListMapper.toArchitecturalDecisionList(systemNode));

                // add non-functional requirements
                systemOfSystems.getNonFunctionalRequirements().addAll(NonFunctionalRequirementListMapper.toNonFunctionalRequirementList(systemNode.nonFunctionalRequirementNodes));

                // add system elements
                systemOfSystems.getSystemElementAggregateList().addAll(SystemElementAggregateListMapper.toSystemElementAggregate(systemNode.systemElementNodes));

                // traverse the system recursively
                traverseSystem(systemNode, systemOfSystems);
            });

            softwareArchitecture.getSystemsOfSystems().add(systemOfSystems);
        });

    }

    /**
     *
     *
     */
    public void traverseSystem(SystemNode systemNode, SystemOfSystems systemOfSystems) {
        if (systemNode == null) {
            return;
        }

        if (systemNode.getSystemNodes() != null && !systemNode.getSystemNodes().isEmpty()) {
            for (SystemNode child : systemNode.getSystemNodes()) {

                SystemOfSystems sos = SystemOfSystems.create();

                sos.getArchitecturalDecisions().addAll(ArchitecturalDecisionListMapper.toArchitecturalDecisionList(child));
                sos.getNonFunctionalRequirements().addAll(NonFunctionalRequirementListMapper.toNonFunctionalRequirementList(child.nonFunctionalRequirementNodes));

                child.systemElementNodes.forEach(systemElementNode -> {

                    SystemElementAggregate systemElementAggregate = SystemElementAggregate.create();

                    /* Constraint */
                    for (ConstraintNode constraintNode : systemElementNode.constraintNodes) {
                        systemElementAggregate.getConstraintList().add(Constraint.create(
                           constraintNode.getId(),
                           constraintNode.getTitle()
                        ));
                    }

                    systemElementAggregate.setSystemElement(
                            SystemElement.create(
                                    systemElementNode.getId(),
                                    systemElementNode.getTitle()
                            )
                    );

                    sos.getSystemElementAggregateList().add(systemElementAggregate);
                });

                sos.setSystemClass(SystemMapper.toSystem(child));

                traverseSystem(child, sos);

                systemOfSystems.getSystemOfSystemsList().add(sos);
            }
        }
    }

}
