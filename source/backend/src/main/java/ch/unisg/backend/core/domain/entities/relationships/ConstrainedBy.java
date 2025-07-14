package ch.unisg.backend.core.domain.entities.relationships;

import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ConstrainedBy {

    private UUID id;
    private SystemElement systemElement;
    private Constraint constraint;

    public ConstrainedBy(UUID id, SystemElement systemElement, Constraint constraint) {
        this.id = id;
        this.systemElement = systemElement;
        this.constraint = constraint;
    }

    public static ConstrainedBy create(UUID id, SystemElement systemElement, Constraint constraint) {
        return new ConstrainedBy(id, systemElement, constraint);
    }
}
