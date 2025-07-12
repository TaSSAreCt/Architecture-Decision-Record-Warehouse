package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.ad.ArchitectureRationale;
import ch.unisg.backend.core.port.in.command.classes.ArchitectureRationaleCommand;
import ch.unisg.backend.core.port.in.query.classes.ArchitectureRationaleQuery;

public interface ArchitectureRationaleUseCase {
    void create(ArchitectureRationaleCommand command);
    ArchitectureRationale findById(ArchitectureRationaleQuery query);
}
