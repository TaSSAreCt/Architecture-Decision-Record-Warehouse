package ch.unisg.sat.core.application;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemClassList;
import ch.unisg.sat.core.port.in.SystemUseCase;
import ch.unisg.sat.core.port.in.command.classes.SystemCommand;
import ch.unisg.sat.core.port.in.query.classes.SystemQuery;
import ch.unisg.sat.core.port.out.SystemPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SystemService implements SystemUseCase {

    private final SystemPort systemPort;

    @Override
    public void addSystem(SystemCommand command) {

        SystemClass system = SystemClass.create(command.id());
        system.setTitle(command.title());

        systemPort.createSystem(system);
    }

    @Override
    public SystemClass getSystemById(SystemQuery query) {
        SystemClass systemClass = SystemClass.create(query.id());
        return systemPort.findSystemById(systemClass);
    }

    @Override
    public SystemClassList getSystemList() {
        SystemClassList systemClassList = SystemClassList.create();
        return systemPort.findSystems(systemClassList);
    }
}
