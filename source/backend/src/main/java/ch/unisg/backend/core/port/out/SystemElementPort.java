package ch.unisg.backend.core.port.out;

import java.util.UUID;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;

public interface SystemElementPort {
  void createSystemElement(SystemElement systemElement);

  SystemElement findSystemElementById(UUID id);
}
