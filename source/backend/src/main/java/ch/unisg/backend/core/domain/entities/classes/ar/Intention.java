package ch.unisg.backend.core.domain.entities.classes.ar;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Intention extends MetaClass implements ArchitectureRequirementType {

    public Intention() {}
    public Intention(String title) {
        super(null, title);
    }
    public Intention(UUID id){super(id, null); }
    public Intention(UUID id, String title) { super(id, title); }

    public static Intention create(UUID id) {
        return new Intention(id);
    }
    public static Intention create(UUID id, String title) {
        return new Intention(id, title);
    }

}
