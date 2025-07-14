package ch.unisg.backend.core.domain.entities.classes.sos;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import lombok.Getter;
import java.util.HashMap;
import java.util.UUID;

@Getter
public class SystemClass extends MetaClass {

    public SystemClass(UUID id, String title) {
        super(id, title);
    }

    public static SystemClass create() {
        return new SystemClass(null, null);
    }

    public static SystemClass create(UUID id) {
        return new SystemClass(id, null);
    }

    public static SystemClass create(UUID id, String title) {
        return new SystemClass(id, title);
    }

    public HashMap<String, Object> toJSON() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("id", this.getId().toString());
        result.put("title", this.getTitle());

        return result;
    }

}
