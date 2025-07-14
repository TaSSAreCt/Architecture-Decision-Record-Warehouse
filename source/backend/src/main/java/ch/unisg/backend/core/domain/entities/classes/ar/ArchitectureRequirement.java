package ch.unisg.backend.core.domain.entities.classes.ar;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ArchitectureRequirement {

    private final List<Constraint> constraint = new ArrayList<>();
    private final List<ArchitecturePrinciple> architecturePrinciple = new ArrayList<>();
    private final List<Intention> intention = new ArrayList<>();
    private final List<NonFunctionalRequirement> nonFunctionalRequirement = new ArrayList<>();

    private ArchitectureRequirement() {}

    public static ArchitectureRequirement create() {
        return new ArchitectureRequirement();
    }

}
