package ch.unisg.backend.core.application;

import ch.unisg.backend.core.domain.aggregate.*;
import ch.unisg.backend.core.domain.entities.classes.ar.*;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.port.in.SoftwareArchitectureUseCase;
import ch.unisg.backend.core.port.in.command.CreateArchitectureRequirement;
import ch.unisg.backend.core.port.out.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SoftwareArchitectureService implements SoftwareArchitectureUseCase {

    private final SoftwareArchitecturePort softwareArchitecturePort;
    private final ConstraintPort constraintPort;
    private final ArchitecturePrinciplePort architecturePrinciplePort;
    private final IntentionPort intentionPort;
    private final NonFunctionalRequirementPort nonFunctionalRequirementPort;
    private final RelationshipManagerPort relationshipManagerPort;

    @Override
    public void create(CreateArchitectureRequirement command) {
        switch (command.type()) {
            case "constraint" -> constraintPort.create(Constraint.create(command.id(), command.title()));
            case "nonFunctionalRequirement" -> nonFunctionalRequirementPort.create(NonFunctionalRequirement.create(command.id(), command.title()));
            case "intention" -> intentionPort.create(Intention.create(command.id(), command.title()));
            case "architecturePrinciple" -> architecturePrinciplePort.create(ArchitecturePrinciple.create(command.id(), command.title()));
        }
    }

    @Override
    public List<SystemClass> getSystemsOfSystems() {
        List<SystemClass> systemsOfSystems = new ArrayList<>();
        softwareArchitecturePort.getSystemsOfSystems(systemsOfSystems);
        return systemsOfSystems;
    }

    @Override
    public ArchitectureRequirement getArchitecturalRequirements() {

        ArchitectureRequirement architectureRequirement = ArchitectureRequirement.create();

        constraintPort.readAll(architectureRequirement.getConstraintList());
        architecturePrinciplePort.readAll(architectureRequirement.getArchitecturePrincipleList());
        intentionPort.readAll(architectureRequirement.getIntentionList());
        nonFunctionalRequirementPort.readAll(architectureRequirement.getNonFunctionalRequirementList());

        return architectureRequirement;
    }

    @Override
    public ArchitecturalKnowledge getArchitecturalKnowledge() {

        ArchitecturalKnowledge architecturalKnowledge = ArchitecturalKnowledge.create();
        softwareArchitecturePort.getArchitecturalKnowledge(architecturalKnowledge);

        return architecturalKnowledge;
    }
}
