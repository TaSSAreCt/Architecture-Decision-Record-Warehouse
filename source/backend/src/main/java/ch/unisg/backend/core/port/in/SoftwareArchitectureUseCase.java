package ch.unisg.backend.core.port.in;

import ch.unisg.backend.core.domain.aggregate.*;
import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturalRequirements;
import ch.unisg.backend.core.domain.entities.classes.ar.ArchitectureRequirement;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.core.port.in.command.CreateArchitectureRequirement;

import java.util.List;

public interface SoftwareArchitectureUseCase {
    List<SystemClass> getSystemsOfSystems();
    ArchitectureDecisionRecordWarehouse getSoftwareArchitectureRepresentation();
    ArchitectureRequirement getArchitecturalRequirements();
    ArchitecturalKnowledge getArchitecturalKnowledge();
    void create(CreateArchitectureRequirement command);
}
