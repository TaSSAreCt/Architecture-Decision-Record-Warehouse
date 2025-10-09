package ch.unisg.backend.core.application;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.port.in.SystemUseCase;
import ch.unisg.backend.core.port.in.command.classes.SystemCommand;
import ch.unisg.backend.core.port.in.query.SystemQuery;
import ch.unisg.backend.core.port.out.SystemPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SystemService implements SystemUseCase {

  private final SystemPort systemPort;

  @Override
  public void addSystem(SystemCommand command) {
    System.out.println(command.isCyber());
    SystemClass system = SystemClass.create(command.id(), command.isCyber());
    System.out.println(system.isCyber());
    system.setTitle(command.title());
    systemPort.createSystem(system);
  }

  @Override
  public SystemClass getSystemById(SystemQuery query) {
    return systemPort.findSystemById(query.id());
  }

  @Override
  public List<SystemClass> getSystemList() {
    return systemPort.findSystems();
  }
}
