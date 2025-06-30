package ch.unisg.sat.core.application;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;
import ch.unisg.sat.core.domain.entities.classes.ad.Issue;
import ch.unisg.sat.core.domain.entities.classes.ar.ArchitectureRequirement;
import ch.unisg.sat.core.domain.entities.classes.ar.Constraint;
import ch.unisg.sat.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.sat.core.domain.entities.relationships.*;
import ch.unisg.sat.core.port.in.RelationshipManagerUseCase;
import ch.unisg.sat.core.port.in.command.relationships.*;
import ch.unisg.sat.core.port.out.RelationshipManagerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class RelationshipManagerService implements RelationshipManagerUseCase {

    private final RelationshipManagerPort relationshipManagerPort;

    @Override
    public UUID create(SolvedByCommand command) {

        Alternative alternative = Alternative.create(command.alternativeCommand().id());
        Issue issue = Issue.create(command.issueCommand().id());

        return relationshipManagerPort.create(SolvedBy.create(alternative, issue));
    }

    @Override
    public UUID create(RaiseCommand command) {

        Issue issue = Issue.create(command.issueCommand().id());
        SystemClass systemClass = SystemClass.create(command.systemCommand().id());

        return relationshipManagerPort.create(Raise.create(UUID.randomUUID(), systemClass, issue));

    }

    @Override
    public UUID create(BelongsToCommand command) {

        SystemClass systemClass = SystemClass.create(command.systemCommand().id());
        SystemElement systemElement = SystemElement.create(command.systemElementCommand().id());

        return relationshipManagerPort.create(BelongsTo.create(UUID.randomUUID(), systemClass, systemElement));
    }

    @Override
    public UUID create(PartOfCommand command) {
        SystemClass parentSystemClass = SystemClass.create(command.parentSystemClass().id());
        SystemClass childSystemClass = SystemClass.create(command.childSystemClass().id());

        return relationshipManagerPort.create(PartOf.create(UUID.randomUUID(), parentSystemClass, childSystemClass));
    }

    @Override
    public UUID create(ConstrainedByCommand command) {
        SystemElement systemElement = SystemElement.create(command.systemElementCommand().id());
        Constraint constraint = Constraint.create(command.constraintCommand().id());

        return relationshipManagerPort.create(ConstrainedBy.create(UUID.randomUUID(), systemElement, constraint));
    }

    @Override
    public UUID create(RequireCommand command) {
        SystemClass systemClass = SystemClass.create(command.systemClassCommand().id());
        NonFunctionalRequirement nonFunctionalRequirement = NonFunctionalRequirement.create(command.nonFunctionalRequirementCommand().id());

        return relationshipManagerPort.create(Require.create(UUID.randomUUID(), systemClass, nonFunctionalRequirement));
    }

    @Override
    public UUID create(JustifiedByCommand command) {
        ArchitectureRationale architectureRationale = ArchitectureRationale.create(command.architectureRationale().id());
        Alternative alternative = Alternative.create(command.alternative().id());

        return relationshipManagerPort.create(JustifiedBy.create(UUID.randomUUID(), architectureRationale, alternative));
    }

    @Override
    public UUID create(ForcedByCommand command) {
        ArchitectureRequirement architectureRequirement = ArchitectureRequirement.create(command.architectureRequirement().id());
        Alternative alternative = Alternative.create(command.alternative().id());

        return relationshipManagerPort.create(ForcedBy.create(UUID.randomUUID(), command.value(), architectureRequirement, alternative));
    }

    @Override
    public UUID create(HasCommand command) {
        SystemClass systemClass = SystemClass.create(command.systemCommand().id());
        ArchitectureRationale architectureRationale = ArchitectureRationale.create(command.architectureRationaleCommand().id());

        return relationshipManagerPort.create(Has.create(UUID.randomUUID(), systemClass, architectureRationale));
    }
}
