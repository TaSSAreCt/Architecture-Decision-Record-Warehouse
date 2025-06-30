package ch.unisg.sat.core.domain.entities.relationships;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ar.ArchitectureRequirement;
import ch.unisg.sat.core.port.in.command.CreateArchitectureRequirement;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ForcedBy extends RelationshipClass {

    private UUID id;
    private double value;
    private ArchitectureRequirement architectureRequirement;
    private Alternative alternative;

    public ForcedBy(UUID id, double value, ArchitectureRequirement architectureRequirement, Alternative alternative) {
        this.id = id;
        this.value = value;
        this.architectureRequirement = architectureRequirement;
        this.alternative = alternative;
    }

    public static ForcedBy create(UUID id, double value, ArchitectureRequirement architectureRequirement, Alternative alternative) {
        return new ForcedBy(id, value, architectureRequirement, alternative);
    }

    public static ForcedBy create(double value, ArchitectureRequirement architectureRequirement, Alternative alternative) {
        return new ForcedBy(UUID.randomUUID(), value, architectureRequirement, alternative);
    }

}
