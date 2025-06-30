package ch.unisg.sat.core.domain.entities.classes.ar;

import ch.unisg.sat.core.domain.aggregate.ArchitecturalRequirement;
import ch.unisg.sat.core.domain.entities.classes.MetaClass;

import java.util.HashMap;
import java.util.UUID;

public class ArchitecturePrinciple extends MetaClass implements ArchitecturalRequirement {

    public ArchitecturePrinciple() {}
    public ArchitecturePrinciple(UUID id) {
        super(id, "");
    }
    public ArchitecturePrinciple(UUID id, String title) {
        super(id, title);
    }

    public static ArchitecturePrinciple create(UUID id) {
        return new ArchitecturePrinciple(id);
    }
    public static ArchitecturePrinciple create(UUID id, String title) {
        return new ArchitecturePrinciple(id, title);
    }

    public HashMap<String, Object> toJson() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("id", this.getId().toString());
        result.put("title", this.getTitle());

        return result;
    }

    public String getType() {
        return "architecturePrinciple";
    }
}
