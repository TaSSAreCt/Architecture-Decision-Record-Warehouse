package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;

import java.util.List;

public interface SystemPort {
    void createSystem(SystemClass systemClass);
    SystemClass findSystemById(SystemClass systemClass);
    List<SystemClass> findSystems();
}
