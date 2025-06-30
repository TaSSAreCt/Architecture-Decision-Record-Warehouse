package ch.unisg.sat.core.domain.entities.classes.ar;

import ch.unisg.sat.core.domain.aggregate.ArchitecturalRequirement;
import ch.unisg.sat.core.domain.entities.classes.MetaClass;
import java.util.UUID;

public class NonFunctionalRequirement extends MetaClass implements ArchitecturalRequirement {

    public NonFunctionalRequirement() {}
    public NonFunctionalRequirement(UUID id, String title) {
        super(id, title);
    }

    public static NonFunctionalRequirement create(UUID id, String title) {
        return new NonFunctionalRequirement(id, title);
    }

    public String getType() {
        return "nonFunctionalRequirement";
    }

    public static NonFunctionalRequirement create(UUID id) {
        return new NonFunctionalRequirement(id, "");
    }

}
