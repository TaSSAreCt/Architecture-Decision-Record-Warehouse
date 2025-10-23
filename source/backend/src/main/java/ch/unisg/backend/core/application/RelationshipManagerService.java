package ch.unisg.backend.core.application;

import ch.unisg.backend.core.domain.entities.classes.Node;
import ch.unisg.backend.core.domain.entities.classes.SystemElementNode;
import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.domain.entities.classes.ad.Issue;
import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.domain.entities.relationships.*;
import ch.unisg.backend.core.port.in.RelationshipManagerUseCase;
import ch.unisg.backend.core.port.in.command.CreateInfluenceCommand;
import ch.unisg.backend.core.port.in.command.relationships.*;
import ch.unisg.backend.core.port.out.RelationshipManagerPort;
import java.util.UUID;
import org.springframework.stereotype.Component;
import ch.unisg.backend.core.domain.entities.classes.ConstraintNode;


@RequiredArgsConstructor
@Component
public class RelationshipManagerService implements RelationshipManagerUseCase {

  private final RelationshipManagerPort relationshipManagerPort;

  @Override
  public void create(CreateInfluenceCommand command) {
    relationshipManagerPort.create(
        command.id(),
        command.value(),
        command.alternativeId(),
        command.architectureRequirementId());
  }

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

    Node systemElement = SystemElementNode.create(command.systemElementCommand().id(), null);
    Node constraint = ConstraintNode.create(command.constraintCommand().id(), null);

    if (command.isCyber()) {
      CyberEdge edge = CyberEdge.create(UUID.randomUUID(), systemElement, constraint);
      relationshipManagerPort.create(edge);
    }

    ConstrainedBy constrainedBy = ConstrainedBy.create(UUID.randomUUID(), systemElement, constraint, command.isCyber());

    return relationshipManagerPort.create(edge);
  }

  @Override
  public UUID create(RequireCommand command) {
    SystemClass systemClass = SystemClass.create(command.systemClassCommand().id());
    NonFunctionalRequirement nonFunctionalRequirement = NonFunctionalRequirement
        .create(command.nonFunctionalRequirementCommand().id());

    return relationshipManagerPort.create(Require.create(UUID.randomUUID(), systemClass, nonFunctionalRequirement));
  }

  @Override
  public UUID create(JustifiedByCommand command) {
    Rationale architectureRationale = Rationale.create(command.architectureRationale().id());
    Alternative alternative = Alternative.create(command.alternative().id());

    return relationshipManagerPort.create(JustifiedBy.create(UUID.randomUUID(), architectureRationale, alternative));
  }

  @Override
  public UUID create(HasCommand command) {
    SystemClass systemClass = SystemClass.create(command.systemCommand().id());
    Rationale architectureRationale = Rationale.create(command.architectureRationaleCommand().id());

    return relationshipManagerPort.create(Has.create(UUID.randomUUID(), systemClass, architectureRationale));
  }
}
