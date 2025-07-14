package ch.unisg.backend.core.domain.entities.classes.ad;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import ch.unisg.backend.core.domain.entities.relationships.Influence;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Alternative extends MetaClass {

    List<Rationale> rationaleList = new ArrayList<>();
    List<Influence> influenceList = new ArrayList<>();

    public Alternative() {}
    public Alternative(UUID id, String title) {
        super(id, title);
    }
    public Alternative(String title) { super(title); }
    public Alternative(UUID id) { super(id); }

    public static Alternative create() {
        return new Alternative();
    }
    public static Alternative create(UUID id) {
        return new Alternative(id);
    }
    public static Alternative create(UUID id, String title) {
        return new Alternative(id, title);
    }

}
