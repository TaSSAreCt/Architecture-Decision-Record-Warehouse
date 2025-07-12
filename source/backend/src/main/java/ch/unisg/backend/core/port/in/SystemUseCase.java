package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClassList;
import ch.unisg.backend.core.port.in.command.classes.SystemCommand;
import ch.unisg.backend.core.port.in.query.classes.SystemQuery;

public interface SystemUseCase {
    void addSystem(SystemCommand command);
    SystemClass getSystemById(SystemQuery query);
    SystemClassList getSystemList();
}
