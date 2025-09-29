package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;

import java.util.List;

public interface ConstraintPort {
    void create(Constraint constraint);
    Constraint readById(Constraint constraint);
    void readAll(List<Constraint> constraintList);
}
