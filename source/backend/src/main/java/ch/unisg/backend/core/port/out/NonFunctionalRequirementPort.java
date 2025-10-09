package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;

import java.util.List;
import java.util.UUID;

public interface NonFunctionalRequirementPort {
  void create(NonFunctionalRequirement nonFunctionalRequirement);

  NonFunctionalRequirement findById(UUID id);

  void readAll(List<NonFunctionalRequirement> nonFunctionalRequirementList);
}
