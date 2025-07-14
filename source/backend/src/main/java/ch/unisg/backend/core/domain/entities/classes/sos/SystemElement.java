package ch.unisg.backend.core.domain.entities.classes.sos;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;

import java.util.HashMap;
import java.util.UUID;

public class SystemElement extends MetaClass {

    public SystemElement() {}
    public SystemElement(UUID id) { super(id); }
    public SystemElement(UUID id, String title) {super(id, title);}

    public static SystemElement create() {
        return new SystemElement();
    }
    public static SystemElement create(UUID id) {
        return new SystemElement(id);
    }
    public static SystemElement create(UUID id, String title) { return new SystemElement(id, title);}

    public HashMap<String, Object> toJson() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("id", this.getId().toString());
        result.put("title", this.getTitle());
        return result;
    }

}
