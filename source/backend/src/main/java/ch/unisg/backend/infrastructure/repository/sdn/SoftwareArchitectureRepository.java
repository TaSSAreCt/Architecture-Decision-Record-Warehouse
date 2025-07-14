package ch.unisg.backend.infrastructure.repository.sdn;

import ch.unisg.backend.core.domain.aggregate.ArchitecturalKnowledge;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.port.out.SoftwareArchitecturePort;
import ch.unisg.backend.infrastructure.repository.sdn.api.ArchitectureRationaleCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.api.IssueCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.api.SystemCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.mapper.IssueMapper;
import ch.unisg.backend.infrastructure.repository.sdn.mapper.SystemMapper;
import ch.unisg.backend.infrastructure.repository.sdn.node.IssueNode;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        architecturalKnowledge.getIssueList().addAll(IssueMapper.toIssueList(issueNodes));
    }

    /**
     *
     *
     */
    @Override
    public void getSystemsOfSystems(List<SystemClass> systemsOfSystems) {

        // find all root nodes
        List<SystemNode> rootNodes = repository.findRoot();

        // iterate of the root nodes
        rootNodes.forEach(rootNode -> {

            // find the system node of root nodes
            Optional<SystemNode> systemNodes = repository.findById(rootNode.getId());
            systemNodes.ifPresent(node -> {

                SystemClass systemClass = SystemMapper.toSystem(node);
                traverseSystem(node, systemClass);
                systemsOfSystems.add(systemClass);

            });
        });

    }

    /**
     *
     *
     */
    public void traverseSystem(SystemNode systemNode, SystemClass system) {
        if (systemNode == null) {
            return;
        }

        if (systemNode.getSystemNodes() != null && !systemNode.getSystemNodes().isEmpty()) {
            for (SystemNode childSystemNode : systemNode.getSystemNodes()) {
                SystemClass childSystem = SystemMapper.toSystem(childSystemNode);
                traverseSystem(childSystemNode, childSystem);
                system.getSystemList().add(childSystem);
            }
        }
    }

}
