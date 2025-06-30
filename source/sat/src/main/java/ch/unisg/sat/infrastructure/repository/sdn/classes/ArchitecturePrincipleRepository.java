package ch.unisg.sat.infrastructure.repository.sdn.classes;

import ch.unisg.sat.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.sat.core.port.out.ArchitecturePrinciplePort;
import ch.unisg.sat.infrastructure.repository.sdn.api.ArchitecturePrincipleCypherPort;
import ch.unisg.sat.infrastructure.repository.sdn.node.ArchitecturePrincipleNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ArchitecturePrincipleRepository implements ArchitecturePrinciplePort {

    private final Neo4jClient client;
    private final ArchitecturePrincipleCypherPort repository;

    @Override
    public void create(ArchitecturePrinciple architecturePrinciple) {
        repository.save(ArchitecturePrincipleNode.create(architecturePrinciple.getId(), architecturePrinciple.getTitle()));
    }

    @Override
    public ArchitecturePrinciple findById(ArchitecturePrinciple architecturePrinciple) {

        Optional<ArchitecturePrincipleNode> entity = repository.findById(architecturePrinciple.getId());

        entity.ifPresent(element -> architecturePrinciple.setTitle(element.getTitle()));
        return architecturePrinciple;
    }

    @Override
    public void readAll(List<ArchitecturePrinciple> architecturePrincipleList) {

        List<ArchitecturePrincipleNode> architecturePrincipleNodeList = repository.findAll();

        for (ArchitecturePrincipleNode architecturePrincipleNode : architecturePrincipleNodeList) {
            architecturePrincipleList.add(ArchitecturePrinciple.create(architecturePrincipleNode.getId(), architecturePrincipleNode.getTitle()));
        }

    }
}
