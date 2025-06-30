package ch.unisg.sat.core.domain.entities.relationships;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.sat.core.domain.entities.classes.sos.SystemElement;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class BelongsTo {

    private UUID id;
    private SystemClass systemClass;
    private SystemElement systemElement;

    public BelongsTo(UUID id, SystemClass systemClass, SystemElement systemElement) {
        this.id = id;
        this.systemClass = systemClass;
        this.systemElement = systemElement;
    }

    public static BelongsTo create(UUID id, SystemClass systemClass, SystemElement systemElement) {
        return new BelongsTo(id, systemClass, systemElement);
    }
}
