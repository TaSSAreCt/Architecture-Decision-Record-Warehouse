package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import ch.unisg.backend.core.port.in.command.classes.ArchitectureRationaleCommand;
import ch.unisg.backend.core.port.in.query.ArchitectureRationaleQuery;

public interface ArchitectureRationaleUseCase {
    void create(ArchitectureRationaleCommand command);
    Rationale findById(ArchitectureRationaleQuery query);
}
