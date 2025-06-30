package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.sat.core.port.in.command.classes.ArchitecturePrincipleCommand;
import ch.unisg.sat.core.port.in.query.classes.ArchitecturePrincipleQuery;

public interface ArchitecturePrincipleUseCase {
    void create(ArchitecturePrincipleCommand command);
    ArchitecturePrinciple findById(ArchitecturePrincipleQuery query);
}
