package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.backend.core.port.in.command.classes.ArchitecturePrincipleCommand;
import ch.unisg.backend.core.port.in.query.classes.ArchitecturePrincipleQuery;

public interface ArchitecturePrincipleUseCase {
    void create(ArchitecturePrincipleCommand command);
    ArchitecturePrinciple findById(ArchitecturePrincipleQuery query);
}
