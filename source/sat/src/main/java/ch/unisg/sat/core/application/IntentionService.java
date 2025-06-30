package ch.unisg.sat.core.application;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ar.Intention;
import ch.unisg.sat.core.port.in.IntentionUseCase;
import ch.unisg.sat.core.port.in.command.classes.IntentionCommand;
import ch.unisg.sat.core.port.in.command.relationships.ForcedByCommand;
import ch.unisg.sat.core.port.in.query.classes.IntentionQuery;
import ch.unisg.sat.core.port.out.IntentionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class IntentionService implements IntentionUseCase {

    private final IntentionPort intentionPort;

    @Override
    public Intention create(IntentionCommand command) {

        Intention intention = new Intention(command.id(), command.title());

        intentionPort.create(intention);

        return intention;
    }

    @Override
    public UUID force(ForcedByCommand forcedByCommand) {

        Alternative alternative = Alternative.create(forcedByCommand.alternative().id());
        Intention intention = Intention.create(forcedByCommand.architectureRequirement().id());
        return intentionPort.force(alternative, intention);
    }

    @Override
    public Intention findIntentionById(IntentionQuery query) {
        return intentionPort.readById(Intention.create(query.id()));
    }
}
