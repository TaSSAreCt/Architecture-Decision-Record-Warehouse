package ch.unisg.backend.core.domain.entities.classes.ar;

import ch.unisg.backend.core.domain.aggregate.ArchitecturalRequirement;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.UUID;

@Getter @Setter
public class Intention implements ArchitecturalRequirement {

    private UUID id;
    private String title;



    public Intention() {}

    public Intention(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public Intention(String title) {
        this.title = title;
    }

    public Intention(UUID id) {
        this.id = id;
    }

    public HashMap<String, Object> toJson() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("id", this.id.toString());
        result.put("title", this.title);

        return result;
    }
    public static Intention create(UUID id) {
        return new Intention(id);
    }
    public static Intention create(UUID id, String title) {
        return new Intention(id, title);
    }

    public String getType() {
        return "intention";
    }

}
