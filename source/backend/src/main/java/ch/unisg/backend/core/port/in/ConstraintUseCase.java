package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.core.port.in.command.classes.ConstraintCommand;
import ch.unisg.backend.core.port.in.query.ConstraintQuery;

public interface ConstraintUseCase {
    void create(ConstraintCommand command);
    Constraint findById(ConstraintQuery query);
}
