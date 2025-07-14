package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.aggregate.ArchitecturalDecisions;
import ch.unisg.backend.core.domain.aggregate.ArchitecturalKnowledge;
import ch.unisg.backend.core.domain.aggregate.SoftwareArchitecture;
import ch.unisg.backend.core.domain.aggregate.SystemOfSystems;

import java.util.List;

public interface SoftwareArchitecturePort {
    void getSoftwareArchitecture(SoftwareArchitecture softwareArchitecture);
    void getSystemsOfSystems(List<SystemOfSystems> systemsOfSystems);
    void getArchitecturalDecisions(ArchitecturalDecisions architecturalDecisions);
    void getArchitecturalKnowledge(ArchitecturalKnowledge architecturalKnowledge);
}
