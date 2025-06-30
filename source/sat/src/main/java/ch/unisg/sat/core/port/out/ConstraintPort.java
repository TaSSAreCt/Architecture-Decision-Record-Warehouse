package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.entities.classes.ar.Constraint;

import java.util.List;

public interface ConstraintPort {
    void create(Constraint constraint);
    Constraint readById(Constraint constraint);
    void readAll(List<Constraint> constraintList);
}
