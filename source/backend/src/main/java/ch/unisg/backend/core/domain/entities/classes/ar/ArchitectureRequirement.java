package ch.unisg.backend.core.domain.entities.classes.ar;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ArchitectureRequirement {

    private final List<Constraint> constraintList = new ArrayList<>();
    private final List<ArchitecturePrinciple> architecturePrincipleList = new ArrayList<>();
    private final List<Intention> intentionList = new ArrayList<>();
    private final List<NonFunctionalRequirement> nonFunctionalRequirementList = new ArrayList<>();

    private ArchitectureRequirement() {}

    public static ArchitectureRequirement create() {
        return new ArchitectureRequirement();
    }

}
