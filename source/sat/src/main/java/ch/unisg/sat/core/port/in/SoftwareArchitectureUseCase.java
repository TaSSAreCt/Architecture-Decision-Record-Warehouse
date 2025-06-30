package ch.unisg.sat.core.port.in;

import ch.unisg.sat.core.domain.aggregate.*;
import ch.unisg.sat.core.port.in.command.CreateArchitectureRequirement;

import java.util.List;

public interface SoftwareArchitectureUseCase {
    List<SystemOfSystems> getSystemsOfSystems();
    SoftwareArchitecture getSoftwareArchitectureRepresentation();
    ArchitecturalRequirements getArchitecturalRequirements();
    ArchitecturalDecisions getArchitecturalDecisions();
    ArchitecturalKnowledge getArchitecturalKnowledge();
    void create(CreateArchitectureRequirement command);
}
