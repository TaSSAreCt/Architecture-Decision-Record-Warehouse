package ch.unisg.sat.core.domain.entities.classes.ad;

import ch.unisg.sat.core.domain.entities.classes.MetaClass;
import ch.unisg.sat.core.domain.entities.relationships.JustificationList;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ArchitectureRationale extends MetaClass {

    private String context;
    private String decision;
    private String status;
    private String consequences;

    private final JustificationList justificationList =  new JustificationList();

    public ArchitectureRationale(UUID id, String title) {
        super(id, title);
    }

    public ArchitectureRationale(UUID id, String title, String context, String decision, String status, String consequences) {
        super(id, title);
        this.context = context;
        this.decision = decision;
        this.status = status;
        this.consequences = consequences;
    }

    public static ArchitectureRationale create(
            UUID id,
            String title,
            String context,
            String decision,
            String status,
            String consequences
    ) {
        return new ArchitectureRationale(id, title, context, decision, status, consequences);
    }

    public static ArchitectureRationale create(UUID id, String title) {
        return new ArchitectureRationale(id, title);
    }

    public static ArchitectureRationale create(UUID id) {
        return new ArchitectureRationale(id, "");
    }
}
