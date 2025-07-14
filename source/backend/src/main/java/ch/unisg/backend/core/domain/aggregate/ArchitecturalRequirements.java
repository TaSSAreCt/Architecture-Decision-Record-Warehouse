package ch.unisg.backend.core.domain.aggregate;

import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.core.domain.entities.classes.ar.Intention;
import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ArchitecturalRequirements {

    private final List<Constraint> constraint = new ArrayList<>();
    private final List<ArchitecturePrinciple> architecturePrinciple = new ArrayList<>();
    private final List<Intention> intention = new ArrayList<>();
    private final List<NonFunctionalRequirement> nonFunctionalRequirement = new ArrayList<>();

    private ArchitecturalRequirements() {}

    public static ArchitecturalRequirements create() {
        return new ArchitecturalRequirements();
    }

}
