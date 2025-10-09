package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;

import java.util.List;
import java.util.UUID;

public interface ConstraintPort {
  void create(Constraint constraint);

  Constraint readById(UUID id);

  void readAll(List<Constraint> constraintList);
}
