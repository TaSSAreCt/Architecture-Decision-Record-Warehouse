package ch.unisg.backend.infrastructure.repository.sdn.classes;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClassList;
import ch.unisg.backend.core.port.out.SystemPort;
import ch.unisg.backend.infrastructure.repository.sdn.api.SystemCypherPort;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SystemRepository implements SystemPort {

    private final Neo4jClient client;
    private final SystemCypherPort repository;

    @Override
    public void createSystem(SystemClass systemClass) {
        SystemNode systemNode = new SystemNode(systemClass.getId(), systemClass.getTitle());
        repository.save(systemNode);
    }

    @Override
    public SystemClass findSystemById(SystemClass systemClass) {

        Optional<SystemNode> systemNode = repository.findById(systemClass.getId());

        systemNode.ifPresent(value -> systemClass.setTitle(value.getTitle()));

        return systemClass;
    }

    @Override
    public SystemClassList findSystems(SystemClassList systemClassList) {

        List<SystemNode> nodes = repository.findAll();

        nodes.forEach(node -> {
            systemClassList.add(SystemClass.create(node.getId(), node.getTitle()));
        });
        return systemClassList;
    }

}
