package ch.unisg.sat.core.application;

import ch.unisg.sat.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.sat.core.port.in.ArchitecturePrincipleUseCase;
import ch.unisg.sat.core.port.in.command.classes.ArchitecturePrincipleCommand;
import ch.unisg.sat.core.port.in.query.classes.ArchitecturePrincipleQuery;
import ch.unisg.sat.core.port.out.ArchitecturePrinciplePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArchitecturePrincipleService implements ArchitecturePrincipleUseCase {

    private final ArchitecturePrinciplePort architecturePrinciplePort;

    @Override
    public void create(ArchitecturePrincipleCommand command) {
        ArchitecturePrinciple architecturePrinciple = ArchitecturePrinciple.create(command.id());
        architecturePrinciple.setTitle(command.title());

        architecturePrinciplePort.create(architecturePrinciple);
    }

    @Override
    public ArchitecturePrinciple findById(ArchitecturePrincipleQuery query) {

        ArchitecturePrinciple architecturePrinciple = ArchitecturePrinciple.create(query.id());
        return architecturePrinciplePort.findById(architecturePrinciple);
    }
}
