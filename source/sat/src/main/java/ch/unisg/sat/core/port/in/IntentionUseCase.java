package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.domain.entities.classes.ar.Intention;
import ch.unisg.sat.core.port.in.command.classes.IntentionCommand;
import ch.unisg.sat.core.port.in.command.relationships.ForcedByCommand;
import ch.unisg.sat.core.port.in.query.classes.IntentionQuery;

import java.util.UUID;

public interface IntentionUseCase {
    Intention create(IntentionCommand command);
    UUID force(ForcedByCommand forcedByCommand);
    Intention findIntentionById(IntentionQuery query);
}
