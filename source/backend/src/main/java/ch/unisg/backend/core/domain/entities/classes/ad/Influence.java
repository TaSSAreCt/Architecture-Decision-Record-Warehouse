package ch.unisg.backend.core.domain.entities.classes.ad;

import ch.unisg.backend.core.domain.entities.classes.ar.ArchitectureRequirementType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Influence {

    private UUID id;
    private float value;
    private Alternative alternative;
    private ArchitectureRequirementType architectureRequirement;

    private Influence(UUID id, Float value, Alternative alternative, ArchitectureRequirementType architectureRequirement) {
        this.id = id;
        this.value = value;
        this.alternative = alternative;
        this.architectureRequirement = architectureRequirement;
    }

    public static Influence create(UUID id, Float value, Alternative alternative, ArchitectureRequirementType architectureRequirement) {
        return new Influence(id, value, alternative, architectureRequirement);
    }

}

