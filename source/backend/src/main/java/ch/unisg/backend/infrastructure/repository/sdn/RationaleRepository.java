package ch.unisg.backend.infrastructure.repository.sdn;

import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import ch.unisg.backend.core.port.out.ArchitectureRationalePort;
import ch.unisg.backend.infrastructure.repository.sdn.api.ArchitectureRationaleCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.RationaleNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class RationaleRepository implements ArchitectureRationalePort {

    private final Neo4jClient client;
    private final ArchitectureRationaleCypherPort repository;


    @Override
    public void create(Rationale architectureRationale) {

        RationaleNode entity = RationaleNode.create(
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
    public Rationale readById(Rationale architectureRationale) {

        Optional<RationaleNode> entity = repository.findById(architectureRationale.getId());

        entity.ifPresent(architectureRationaleNode -> architectureRationale.setTitle(architectureRationaleNode.getTitle()));

        return architectureRationale;
    }
}
