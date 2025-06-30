package ch.unisg.sat.core.domain.entities.relationships;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
public class PartOf extends RelationshipClass {

    private UUID id;
    private SystemClass parentSystemClass;
    private SystemClass childSystemClass;

    public PartOf(UUID id, SystemClass parentSystemClass, SystemClass childSystemClass) {
        this.id = id;
        this.parentSystemClass = parentSystemClass;
        this.childSystemClass = childSystemClass;
    }

    public static PartOf create(UUID id, SystemClass parentSystemClass, SystemClass childSystemClass) {
        return new PartOf(id, parentSystemClass, childSystemClass);
    }

}
