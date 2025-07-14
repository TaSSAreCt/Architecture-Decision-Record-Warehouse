package ch.unisg.backend.core.domain.entities.classes.ad;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import ch.unisg.backend.core.domain.entities.relationships.Influence;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Issue extends MetaClass {


    private final List<Alternative> alternativeList = new ArrayList<>();
    private final List<Rationale> rationaleList = new ArrayList<>();
    private final List<Influence> influenceList = new ArrayList<>();

    public Issue(UUID id, String title) {
        super(id, title);
    }

    public static Issue create() {
        return new Issue(null, null);
    }
    public static Issue create(UUID id) {
        return new Issue(id, null);
    }
    public static Issue create(UUID id, String title) {
        return new Issue(id, title);
    }

}
