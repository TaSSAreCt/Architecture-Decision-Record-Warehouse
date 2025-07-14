package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.ar.Intention;
import ch.unisg.backend.core.port.in.command.classes.IntentionCommand;
import ch.unisg.backend.core.port.in.command.relationships.ForcedByCommand;
import ch.unisg.backend.core.port.in.query.IntentionQuery;

import java.util.UUID;

public interface IntentionUseCase {
    Intention create(IntentionCommand command);
    Intention findIntentionById(IntentionQuery query);
}
