package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.sat.core.port.in.command.CreateSystemElementCommand;
import ch.unisg.sat.core.port.in.query.classes.SystemElementQuery;

public interface SystemElementUseCase {
    void addSystemElement(CreateSystemElementCommand command);
    SystemElement getSystemElementById(SystemElementQuery query);
}
