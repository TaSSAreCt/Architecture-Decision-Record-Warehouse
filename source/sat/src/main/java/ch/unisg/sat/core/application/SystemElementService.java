package ch.unisg.sat.core.application;

import ch.unisg.sat.core.domain.event.SystemElementCreatedEvent;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.sat.core.port.in.SystemElementUseCase;
import ch.unisg.sat.core.port.in.command.CreateSystemElementCommand;
import ch.unisg.sat.core.port.in.query.classes.SystemElementQuery;
import ch.unisg.sat.core.port.out.SystemElementPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SystemElementService implements SystemElementUseCase {

    private final ApplicationEventPublisher eventPublisher;

    private final SystemElementPort systemElementPort;

    @Override
    public void addSystemElement(CreateSystemElementCommand command) {

        SystemElement systemElement = SystemElement.create(
                command.id(),
                command.title()
        );

        SystemClass systemClass = SystemClass.create(
                command.systemId()
        );

        systemElementPort.createSystemElement(systemElement);

        SystemElementCreatedEvent event = new SystemElementCreatedEvent(this, systemClass, systemElement);
        eventPublisher.publishEvent(event);
    }

    @Override
    public SystemElement getSystemElementById(SystemElementQuery query) {

        SystemElement systemElement = new SystemElement();

        systemElement.setId(query.id());

        return systemElementPort.findSystemElementById(systemElement);

    }
}
