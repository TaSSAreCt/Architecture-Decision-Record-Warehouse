package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;

import java.util.List;

public interface NonFunctionalRequirementPort {
    void create(NonFunctionalRequirement nonFunctionalRequirement);
    NonFunctionalRequirement findById(NonFunctionalRequirement nonFunctionalRequirement);
    void readAll(List<NonFunctionalRequirement> nonFunctionalRequirementList);
}
