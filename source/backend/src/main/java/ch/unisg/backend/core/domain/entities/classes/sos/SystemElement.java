package ch.unisg.backend.core.domain.entities.classes.sos;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class SystemElement extends MetaClass {

    private final List<Constraint> constraintList = new ArrayList<>();

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
}
