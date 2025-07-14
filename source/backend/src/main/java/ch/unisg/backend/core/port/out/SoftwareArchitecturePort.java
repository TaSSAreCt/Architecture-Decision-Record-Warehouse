package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.aggregate.ArchitecturalKnowledge;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;

import java.util.List;

public interface SoftwareArchitecturePort {
    void getSystemsOfSystems(List<SystemClass> systemsOfSystems);
    void getArchitecturalKnowledge(ArchitecturalKnowledge architecturalKnowledge);
}
