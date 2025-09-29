package ch.unisg.backend.core.domain.entities.classes.ar;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Constraint extends MetaClass implements ArchitectureRequirementType {

    public Constraint() {}
    public Constraint(UUID id) {
        super(id);
    }
    public Constraint(UUID id, String title) {
        super(id, title);
    }

    public static Constraint create() {
        return new Constraint();
    }

    public static Constraint create(UUID id) {
        return new Constraint(id);
    }

    public static Constraint create(UUID id, String title) {
        return new Constraint(id, title);
    }

    public String getType() {
        return "constraint";
    }

}
