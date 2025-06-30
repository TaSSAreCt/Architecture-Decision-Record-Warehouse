package ch.unisg.sat.core.domain.entities.relationships;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Justification extends RelationshipClass {

    private ArchitectureRationale rationale;

    private Alternative alternative;

    public Justification(ArchitectureRationale rationale, Alternative alternative) {
        this.rationale = rationale;
        this.alternative = alternative;
    }


}
