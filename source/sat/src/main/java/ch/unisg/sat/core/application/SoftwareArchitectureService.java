package ch.unisg.sat.core.application;

import ch.unisg.sat.core.domain.aggregate.*;
import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ar.*;
import ch.unisg.sat.core.domain.entities.relationships.ForcedBy;
import ch.unisg.sat.core.port.in.SoftwareArchitectureUseCase;
import ch.unisg.sat.core.port.in.command.CreateArchitectureRequirement;
import ch.unisg.sat.core.port.out.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

        ArchitectureRequirement architectureRequirement = ArchitectureRequirement.create(command.id());
        Alternative alternative = Alternative.create(command.alternativeId());

        relationshipManagerPort.create(
            ForcedBy.create(
                command.value(),
                architectureRequirement,
                alternative
            )
        );
    }

    @Override
    public SoftwareArchitecture getSoftwareArchitectureRepresentation() {

        SoftwareArchitecture softwareArchitecture = SoftwareArchitecture.create();

        softwareArchitecturePort.getSoftwareArchitecture(softwareArchitecture);

        return softwareArchitecture;
    }

    @Override
    public ArchitecturalDecisions getArchitecturalDecisions() {
        ArchitecturalDecisions architecturalDecisions = ArchitecturalDecisions.create();

        softwareArchitecturePort.getArchitecturalDecisions(architecturalDecisions);

        return architecturalDecisions;
    }

    @Override
    public List<SystemOfSystems> getSystemsOfSystems() {


        List<SystemOfSystems> systemsOfSystems = new ArrayList<>();

        softwareArchitecturePort.getSystemsOfSystems(systemsOfSystems);

        return systemsOfSystems;
    }

    @Override
    public ArchitecturalRequirements getArchitecturalRequirements() {

        ArchitecturalRequirements architecturalRequirements = ArchitecturalRequirements.create();

        constraintPort.readAll(architecturalRequirements.getConstraint());
        architecturePrinciplePort.readAll(architecturalRequirements.getArchitecturePrinciple());
        intentionPort.readAll(architecturalRequirements.getIntention());
        nonFunctionalRequirementPort.readAll(architecturalRequirements.getNonFunctionalRequirement());

        return architecturalRequirements;
    }

    @Override
    public ArchitecturalKnowledge getArchitecturalKnowledge() {

        ArchitecturalKnowledge architecturalKnowledge = ArchitecturalKnowledge.create();
        softwareArchitecturePort.getArchitecturalKnowledge(architecturalKnowledge);

        return architecturalKnowledge;
    }
}
