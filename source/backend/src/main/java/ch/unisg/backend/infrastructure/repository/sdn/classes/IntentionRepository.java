package ch.unisg.backend.infrastructure.repository.sdn.classes;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.domain.entities.classes.ar.Intention;
import ch.unisg.backend.core.port.out.IntentionPort;
import ch.unisg.backend.infrastructure.repository.sdn.api.IntentionCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.IntentionNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class IntentionRepository implements IntentionPort {

    private final Neo4jClient client;
    private final IntentionCypherPort repository;

    @Override
    public void create(Intention intention) {
        repository.save(IntentionNode.create(intention.getId(), intention.getTitle()));
    }


    @Override
    public Intention readById(Intention intention) {

        Optional<IntentionNode> entity = repository.findById(intention.getId());

        entity.ifPresent(element -> intention.setTitle(element.getTitle()));

        return intention;

    }

    @Override
    public UUID force(Alternative alternative, Intention intention) {

        UUID id = UUID.randomUUID();

        client.query("""
                    MATCH (i:Intention {id: $intentionId})
                    MATCH (a:Alternatives {id: $alternativeId})
                    MERGE (a)-[:FORCED_BY {id: $id, value: $value}]->(i)
                """)
                .bind(intention.getId().toString()).to("intentionId")
                .bind(alternative.getId().toString()).to("alternativeId")
                .bind(id.toString()).to("id")
                .bind(10).to("value")
                .run();

        return id;
    }

    @Override
    public void readAll(List<Intention> intentionList) {
        List<IntentionNode> intentionNodeList = repository.findAll();

        for (IntentionNode intentionNode : intentionNodeList) {
            intentionList.add(Intention.create(intentionNode.getId(), intentionNode.getTitle()));
        }
    }
}
