package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemClassList;

public interface SystemPort {
    void createSystem(SystemClass systemClass);
    SystemClass findSystemById(SystemClass systemClass);
    SystemClassList findSystems(SystemClassList systemClassList);
}
