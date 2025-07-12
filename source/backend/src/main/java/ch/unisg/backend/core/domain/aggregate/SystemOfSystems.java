package ch.unisg.backend.core.domain.aggregate;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class SystemOfSystems {

    private SystemClass systemClass;
    private final List<SystemOfSystems> systemOfSystemsList = new ArrayList<>();
    private final List<SystemElementAggregate> systemElementAggregateList = new ArrayList<>();
    private final List<NonFunctionalRequirement> nonFunctionalRequirements = new ArrayList<>();
    private final List<ArchitectureDecision> architecturalDecisions = new ArrayList<>();

    private SystemOfSystems() {
        this.systemClass = SystemClass.create();
    }
    private SystemOfSystems(SystemClass systemClass) {
        this.systemClass = systemClass;
    }

    public static SystemOfSystems create() {
        return new SystemOfSystems();
    }
    public static SystemOfSystems create(SystemClass systemClass) {
        return new SystemOfSystems(systemClass);
    }

}
