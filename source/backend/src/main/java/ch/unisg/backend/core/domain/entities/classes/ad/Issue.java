package ch.unisg.backend.core.domain.entities.classes.ad;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Issue extends MetaClass {

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
