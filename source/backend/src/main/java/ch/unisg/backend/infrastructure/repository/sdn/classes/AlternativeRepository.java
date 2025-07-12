package ch.unisg.backend.infrastructure.repository.sdn.classes;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.port.out.AlternativePort;
import ch.unisg.backend.infrastructure.repository.sdn.api.AlternativeCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.AlternativeNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AlternativeRepository implements AlternativePort {

    private final AlternativeCypherPort repository;
    private final Neo4jClient client;

    @Override
    public void createAlternative(Alternative alternative) {

        AlternativeNode entity = AlternativeNode.create(alternative.getId(), alternative.getTitle());
        repository.save(entity);
    }

    @Override
    public Alternative readAlternativeById(Alternative alternative) {

        Optional<AlternativeNode> entity = repository.findById(alternative.getId());

        entity.ifPresent(alternativeNode -> alternative.setTitle(alternativeNode.getTitle()));

        return alternative;
    }
}
