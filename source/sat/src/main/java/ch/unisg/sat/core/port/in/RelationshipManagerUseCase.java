package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.port.in.command.relationships.*;

import java.util.UUID;

public interface RelationshipManagerUseCase {

    UUID create(SolvedByCommand command);
    UUID create(RaiseCommand command);
    UUID create(BelongsToCommand command);
    UUID create(PartOfCommand command);
    UUID create(ConstrainedByCommand command);
    UUID create(RequireCommand command);
    UUID create(JustifiedByCommand command);
    UUID create(ForcedByCommand command);
    UUID create(HasCommand command);
}
