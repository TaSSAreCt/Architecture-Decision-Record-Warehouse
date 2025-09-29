package ch.unisg.backend.controller.event;

import ch.unisg.backend.core.domain.event.SystemElementCreatedEvent;
import ch.unisg.backend.core.port.in.RelationshipManagerUseCase;
import ch.unisg.backend.core.port.in.command.classes.SystemCommand;
import ch.unisg.backend.core.port.in.command.classes.SystemElementCommand;
import ch.unisg.backend.core.port.in.command.relationships.BelongsToCommand;
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
