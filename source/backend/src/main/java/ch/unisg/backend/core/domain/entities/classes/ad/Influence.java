package ch.unisg.backend.core.domain.entities.classes.ad;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Influence {

    private UUID id;
    private Alternative alternative;
    private Object architectureRequirement;

    private Influence(UUID id, Alternative alternative, Object architectureRequirement) {
        this.id = id;
        this.alternative = alternative;
        this.architectureRequirement = architectureRequirement;
    }

    public static Influence create(UUID id, Alternative alternative, Object architectureRequirement) {
        return new Influence(id, alternative, architectureRequirement);
    }

}

