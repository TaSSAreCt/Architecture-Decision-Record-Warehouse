package ch.unisg.backend.core.domain.entities.relationships;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class JustifiedBy {

    private UUID id;
    private Rationale architectureRationale;
    private Alternative alternative;

    public JustifiedBy(UUID id, Rationale architectureRationale, Alternative alternative) {
        this.id = id;
        this.architectureRationale = architectureRationale;
        this.alternative = alternative;
    }

    public static JustifiedBy create(UUID id, Rationale architectureRationale, Alternative alternative) {
        return new JustifiedBy(id, architectureRationale, alternative);
    }

}
