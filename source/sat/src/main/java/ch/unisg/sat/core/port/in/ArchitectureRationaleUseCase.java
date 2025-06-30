package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;
import ch.unisg.sat.core.port.in.command.classes.ArchitectureRationaleCommand;
import ch.unisg.sat.core.port.in.query.classes.ArchitectureRationaleQuery;

public interface ArchitectureRationaleUseCase {
    void create(ArchitectureRationaleCommand command);
    ArchitectureRationale findById(ArchitectureRationaleQuery query);
}
