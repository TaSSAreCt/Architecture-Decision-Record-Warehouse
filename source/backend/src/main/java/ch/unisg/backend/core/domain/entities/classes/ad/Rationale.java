package ch.unisg.backend.core.domain.entities.classes.ad;

import ch.unisg.backend.core.domain.entities.classes.MetaClass;
import ch.unisg.backend.core.domain.entities.relationships.JustificationList;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Rationale extends MetaClass {

    private String context;
    private String decision;
    private String status;
    private String consequences;

    private final JustificationList justificationList =  new JustificationList();

    public Rationale(UUID id, String title) {
        super(id, title);
    }

    public Rationale(UUID id, String title, String context, String decision, String status, String consequences) {
        super(id, title);
        this.context = context;
        this.decision = decision;
        this.status = status;
        this.consequences = consequences;
    }

    public static Rationale create(
            UUID id,
            String title,
            String context,
            String decision,
            String status,
            String consequences
    ) {
        return new Rationale(id, title, context, decision, status, consequences);
    }

    public static Rationale create(UUID id, String title) {
        return new Rationale(id, title);
    }

    public static Rationale create(UUID id) {
        return new Rationale(id, "");
    }
}
