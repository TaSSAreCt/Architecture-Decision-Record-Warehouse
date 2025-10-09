package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;

import java.util.List;
import java.util.UUID;

public interface SystemPort {
  void createSystem(SystemClass systemClass);

  SystemClass findSystemById(UUID id);

  List<SystemClass> findSystems();
}
