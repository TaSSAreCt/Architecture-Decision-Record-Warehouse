package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.core.port.in.command.classes.NonFunctionalRequirementCommand;
import ch.unisg.backend.core.port.in.query.classes.NonFunctionalRequirementQuery;

public interface NonFunctionalRequirementUseCase {
    void create(NonFunctionalRequirementCommand command);
    NonFunctionalRequirement findById(NonFunctionalRequirementQuery query);
}
