package ch.unisg.sat.core.domain.entities.relationships;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class JustifiedBy {

    private UUID id;
    private ArchitectureRationale architectureRationale;
    private Alternative alternative;

    public JustifiedBy(UUID id, ArchitectureRationale architectureRationale, Alternative alternative) {
        this.id = id;
        this.architectureRationale = architectureRationale;
        this.alternative = alternative;
    }

    public static JustifiedBy create(UUID id, ArchitectureRationale architectureRationale, Alternative alternative) {
        return new JustifiedBy(id, architectureRationale, alternative);
    }

}
