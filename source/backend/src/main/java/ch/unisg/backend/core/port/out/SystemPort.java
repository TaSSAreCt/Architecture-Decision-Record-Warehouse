package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClassList;

public interface SystemPort {
    void createSystem(SystemClass systemClass);
    SystemClass findSystemById(SystemClass systemClass);
    SystemClassList findSystems(SystemClassList systemClassList);
}
