package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.aggregate.ArchitecturalKnowledge;
import ch.unisg.backend.core.domain.aggregate.ArchitectureDecisionRecordWarehouse;

import java.util.List;

public interface SoftwareArchitecturePort {
    void getSoftwareArchitecture(ArchitectureDecisionRecordWarehouse softwareArchitecture);
    void getSystemsOfSystems(List<SystemOfSystems> systemsOfSystems);
    void getArchitecturalDecisions(ArchitecturalDecisions architecturalDecisions);
    void getArchitecturalKnowledge(ArchitecturalKnowledge architecturalKnowledge);
}
