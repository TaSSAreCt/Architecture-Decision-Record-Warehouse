package ch.unisg.backend.core.domain.entities.relationships;

import ch.unisg.backend.core.domain.entities.classes.ar.NonFunctionalRequirement;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
public class Require extends RelationshipClass {

    private UUID id;
    private SystemClass systemClass;
    private NonFunctionalRequirement nonFunctionalRequirement;

    public Require(UUID id, SystemClass systemClass, NonFunctionalRequirement nonFunctionalRequirement) {
        this.id = id;
        this.systemClass = systemClass;
        this.nonFunctionalRequirement = nonFunctionalRequirement;
    }

    public static Require create(UUID id, SystemClass systemClass, NonFunctionalRequirement nonFunctionalRequirement) {
        return new Require(id, systemClass, nonFunctionalRequirement);
    }

}
