package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.sat.core.port.in.command.classes.NonFunctionalRequirementCommand;
import ch.unisg.sat.core.port.in.query.classes.NonFunctionalRequirementQuery;

public interface NonFunctionalRequirementUseCase {
    void create(NonFunctionalRequirementCommand command);
    NonFunctionalRequirement findById(NonFunctionalRequirementQuery query);
}
