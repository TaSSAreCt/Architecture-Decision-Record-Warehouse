package ch.unisg.sat.core.domain.entities.relationships;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;
import ch.unisg.sat.core.domain.entities.classes.ar.ArchitectureRequirement;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Has extends RelationshipClass {

    private UUID id;
    private ArchitectureRationale architectureRationale;
    private SystemClass systemClass;

    public Has(UUID id, SystemClass systemClass, ArchitectureRationale architectureRationale) {
        this.id = id;
        this.systemClass = systemClass;
        this.architectureRationale = architectureRationale;
    }

    public static Has create(UUID id, SystemClass systemClass, ArchitectureRationale architectureRationale) {
        return new Has(id, systemClass, architectureRationale);
    }
}
