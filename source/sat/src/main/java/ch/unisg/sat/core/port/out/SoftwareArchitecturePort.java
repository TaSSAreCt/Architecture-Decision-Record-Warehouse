package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.aggregate.ArchitecturalDecisions;
import ch.unisg.sat.core.domain.aggregate.ArchitecturalKnowledge;
import ch.unisg.sat.core.domain.aggregate.SoftwareArchitecture;
import ch.unisg.sat.core.domain.aggregate.SystemOfSystems;

import java.util.List;

public interface SoftwareArchitecturePort {
    void getSoftwareArchitecture(SoftwareArchitecture softwareArchitecture);
    void getSystemsOfSystems(List<SystemOfSystems> systemsOfSystems);
    void getArchitecturalDecisions(ArchitecturalDecisions architecturalDecisions);
    void getArchitecturalKnowledge(ArchitecturalKnowledge architecturalKnowledge);
}
