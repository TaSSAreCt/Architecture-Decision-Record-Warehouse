package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.port.in.command.CreateInfluenceCommand;
import ch.unisg.backend.core.port.in.command.relationships.*;

import java.util.UUID;

public interface RelationshipManagerUseCase {

    void create(CreateInfluenceCommand command);
    UUID create(SolvedByCommand command);
    UUID create(RaiseCommand command);
    UUID create(BelongsToCommand command);
    UUID create(PartOfCommand command);
    UUID create(ConstrainedByCommand command);
    UUID create(RequireCommand command);
    UUID create(JustifiedByCommand command);
    UUID create(HasCommand command);
}
