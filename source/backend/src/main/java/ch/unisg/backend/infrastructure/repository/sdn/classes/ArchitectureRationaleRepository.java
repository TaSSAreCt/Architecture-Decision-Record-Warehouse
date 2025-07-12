package ch.unisg.backend.infrastructure.repository.sdn.classes;

import ch.unisg.backend.core.domain.entities.classes.ad.ArchitectureRationale;
import ch.unisg.backend.core.port.out.ArchitectureRationalePort;
import ch.unisg.backend.infrastructure.repository.sdn.api.ArchitectureRationaleCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.ArchitectureRationaleNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ArchitectureRationaleRepository implements ArchitectureRationalePort {

    private final Neo4jClient client;
    private final ArchitectureRationaleCypherPort repository;


    @Override
    public void create(ArchitectureRationale architectureRationale) {

        ArchitectureRationaleNode entity = ArchitectureRationaleNode.create(
                architectureRationale.getId(),
                architectureRationale.getTitle(),
                architectureRationale.getContext(),
                architectureRationale.getDecision(),
                architectureRationale.getStatus(),
                architectureRationale.getConsequences()
        );

        repository.save(entity);

    }

    @Override
    public ArchitectureRationale readById(ArchitectureRationale architectureRationale) {

        Optional<ArchitectureRationaleNode> entity = repository.findById(architectureRationale.getId());

        entity.ifPresent(architectureRationaleNode -> architectureRationale.setTitle(architectureRationaleNode.getTitle()));

        return architectureRationale;
    }
}
