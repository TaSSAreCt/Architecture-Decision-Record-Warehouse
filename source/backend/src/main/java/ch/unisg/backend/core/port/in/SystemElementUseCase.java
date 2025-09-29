package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.backend.core.port.in.command.CreateSystemElementCommand;
import ch.unisg.backend.core.port.in.query.SystemElementQuery;

public interface SystemElementUseCase {
    void addSystemElement(CreateSystemElementCommand command);
    SystemElement getSystemElementById(SystemElementQuery query);
}
