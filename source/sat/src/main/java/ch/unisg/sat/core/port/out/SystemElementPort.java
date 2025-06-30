package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemElement;

public interface SystemElementPort {
    void createSystemElement(SystemElement systemElement);
    SystemElement findSystemElementById(SystemElement systemElement);
    void linkSystemElementToSystem(SystemElement systemElement, SystemClass systemClass);
}
