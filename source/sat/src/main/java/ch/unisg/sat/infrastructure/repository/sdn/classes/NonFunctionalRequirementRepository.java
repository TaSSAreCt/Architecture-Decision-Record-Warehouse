package ch.unisg.sat.infrastructure.repository.sdn.classes;

import ch.unisg.sat.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.sat.core.port.out.NonFunctionalRequirementPort;
import ch.unisg.sat.infrastructure.repository.sdn.api.NonFunctionalRequirementCypherPort;
import ch.unisg.sat.infrastructure.repository.sdn.node.NonFunctionalRequirementNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class NonFunctionalRequirementRepository implements NonFunctionalRequirementPort {

    private final NonFunctionalRequirementCypherPort repository;

    @Override
    public void create(NonFunctionalRequirement nonFunctionalRequirement) {
        repository.save(NonFunctionalRequirementNode.create(nonFunctionalRequirement.getId(), nonFunctionalRequirement.getTitle()));
    }

    @Override
    public NonFunctionalRequirement findById(NonFunctionalRequirement nonFunctionalRequirement) {

        Optional<NonFunctionalRequirementNode> entity = repository.findById(nonFunctionalRequirement.getId());

        entity.ifPresent(element -> nonFunctionalRequirement.setTitle(element.getTitle()));

        return nonFunctionalRequirement;
    }

    @Override
    public void readAll(List<NonFunctionalRequirement> nonFunctionalRequirementList) {
        List<NonFunctionalRequirementNode> nonFunctionalRequirementNodeList = repository.findAll();

        for (NonFunctionalRequirementNode nonFunctionalRequirementNode : nonFunctionalRequirementNodeList) {
            nonFunctionalRequirementList.add(NonFunctionalRequirement.create(nonFunctionalRequirementNode.getId(), nonFunctionalRequirementNode.getTitle()));
        }
    }
}
