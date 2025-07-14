package ch.unisg.backend.core.application;

import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.backend.core.port.in.ArchitecturePrincipleUseCase;
import ch.unisg.backend.core.port.in.command.classes.ArchitecturePrincipleCommand;
import ch.unisg.backend.core.port.in.query.ArchitecturePrincipleQuery;
import ch.unisg.backend.core.port.out.ArchitecturePrinciplePort;
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
