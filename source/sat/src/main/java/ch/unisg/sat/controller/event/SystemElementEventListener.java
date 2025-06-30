package ch.unisg.sat.controller.event;

import ch.unisg.sat.core.domain.event.SystemElementCreatedEvent;
import ch.unisg.sat.core.port.in.RelationshipManagerUseCase;
import ch.unisg.sat.core.port.in.command.classes.SystemCommand;
import ch.unisg.sat.core.port.in.command.classes.SystemElementCommand;
import ch.unisg.sat.core.port.in.command.relationships.BelongsToCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SystemElementEventListener {

    private final RelationshipManagerUseCase relationshipManagerUseCase;

    @EventListener
    public void handleSystemElementCreated(SystemElementCreatedEvent event) {

        BelongsToCommand command = BelongsToCommand.create(
                SystemCommand.create(event.getSystemClass().getId()),
                SystemElementCommand.create(event.getSystemElement().getId())
        );

        UUID id = relationshipManagerUseCase.create(command);
    }
}
