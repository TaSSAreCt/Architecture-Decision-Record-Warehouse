package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;

public interface SystemElementPort {
    void createSystemElement(SystemElement systemElement);
    SystemElement findSystemElementById(SystemElement systemElement);
}
