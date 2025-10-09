package ch.unisg.backend.core.application;

import ch.unisg.backend.core.domain.event.SystemElementCreatedEvent;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.backend.core.port.in.SystemElementUseCase;
import ch.unisg.backend.core.port.in.command.CreateSystemElementCommand;
import ch.unisg.backend.core.port.in.query.SystemElementQuery;
import ch.unisg.backend.core.port.out.SystemElementPort;
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
        command.title(),
        command.isCyber());

    SystemClass systemClass = SystemClass.create(
        command.systemId());

    systemElementPort.createSystemElement(systemElement);

    SystemElementCreatedEvent event = new SystemElementCreatedEvent(this, systemClass, systemElement);
    eventPublisher.publishEvent(event);
  }

  @Override
  public SystemElement getSystemElementById(SystemElementQuery query) {
    return systemElementPort.findSystemElementById(query.id());

  }
}
