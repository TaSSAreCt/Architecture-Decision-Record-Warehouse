package ch.unisg.sat.core.application;

import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;
import ch.unisg.sat.core.port.in.ArchitectureRationaleUseCase;
import ch.unisg.sat.core.port.in.command.classes.ArchitectureRationaleCommand;
import ch.unisg.sat.core.port.in.query.classes.ArchitectureRationaleQuery;
import ch.unisg.sat.core.port.out.ArchitectureRationalePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArchitectureRationaleService implements ArchitectureRationaleUseCase {

    private final ArchitectureRationalePort architectureRationalePort;

    @Override
    public void create(ArchitectureRationaleCommand command) {

        ArchitectureRationale architectureRationale = ArchitectureRationale.create(
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
    public ArchitectureRationale findById(ArchitectureRationaleQuery query) {

        ArchitectureRationale architectureRationale = ArchitectureRationale.create(query.id());

        return architectureRationalePort.readById(architectureRationale);
    }
}
