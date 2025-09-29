package ch.unisg.backend.core.application;

import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import ch.unisg.backend.core.port.in.ArchitectureRationaleUseCase;
import ch.unisg.backend.core.port.in.command.classes.ArchitectureRationaleCommand;
import ch.unisg.backend.core.port.in.query.ArchitectureRationaleQuery;
import ch.unisg.backend.core.port.out.ArchitectureRationalePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArchitectureRationaleService implements ArchitectureRationaleUseCase {

    private final ArchitectureRationalePort architectureRationalePort;

    @Override
    public void create(ArchitectureRationaleCommand command) {

        Rationale architectureRationale = Rationale.create(
                command.id(),
                command.title(),
                command.context(),
                command.decision(),
                command.status(),
                command.consequences()
        );

        architectureRationalePort.create(architectureRationale);
    }

    @Override
    public Rationale findById(ArchitectureRationaleQuery query) {

        Rationale architectureRationale = Rationale.create(query.id());

        return architectureRationalePort.readById(architectureRationale);
    }
}
