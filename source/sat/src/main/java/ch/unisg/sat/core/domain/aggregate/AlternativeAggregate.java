package ch.unisg.sat.core.domain.aggregate;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class AlternativeAggregate {

    private final Alternative alternative;
    private final List<ArchitectureRationale> architectureRationales = new ArrayList<>();
    private final List<ForcedBy> forcedBy = new ArrayList<>();

    private AlternativeAggregate() {
        this.alternative = Alternative.create();
    }

    private AlternativeAggregate(UUID id, String title) {
        this.alternative = Alternative.create(id, title);
    }

    public static AlternativeAggregate create() {
        return new AlternativeAggregate();
    }

    public static AlternativeAggregate create(UUID id, String title) {
        return new AlternativeAggregate(id, title);
    }
}
