package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.entities.classes.ar.NonFunctionalRequirement;

import java.util.List;

public interface NonFunctionalRequirementPort {
    void create(NonFunctionalRequirement nonFunctionalRequirement);
    NonFunctionalRequirement findById(NonFunctionalRequirement nonFunctionalRequirement);
    void readAll(List<NonFunctionalRequirement> nonFunctionalRequirementList);
}
