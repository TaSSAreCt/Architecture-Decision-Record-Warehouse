package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.domain.entities.classes.ar.Constraint;
import ch.unisg.sat.core.port.in.command.classes.ConstraintCommand;
import ch.unisg.sat.core.port.in.query.classes.ConstraintQuery;

public interface ConstraintUseCase {
    void create(ConstraintCommand command);
    Constraint findById(ConstraintQuery query);
}
