package ch.unisg.backend.core.application;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.core.port.in.NonFunctionalRequirementUseCase;
import ch.unisg.backend.core.port.in.command.classes.NonFunctionalRequirementCommand;
import ch.unisg.backend.core.port.in.query.NonFunctionalRequirementQuery;
import ch.unisg.backend.core.port.out.NonFunctionalRequirementPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NonFunctionalRequirementService implements NonFunctionalRequirementUseCase {

  private final NonFunctionalRequirementPort nonFunctionalRequirementPort;

  @Override
  public void create(NonFunctionalRequirementCommand command) {
    NonFunctionalRequirement nonFunctionalRequirement = NonFunctionalRequirement.create(command.id(), command.title(),
        command.isCyber());
    nonFunctionalRequirementPort.create(nonFunctionalRequirement);
  }

  @Override
  public NonFunctionalRequirement findById(NonFunctionalRequirementQuery query) {
    return nonFunctionalRequirementPort.findById(query.id());
  }
}
