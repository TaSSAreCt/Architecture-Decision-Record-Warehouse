package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.entities.relationships.*;

import java.util.UUID;

public interface RelationshipManagerPort {
    UUID create(SolvedBy solvedBy);
    UUID create(Raise raise);
    UUID create(BelongsTo belongsTo);
    UUID create(PartOf partOf);
    UUID create(ConstrainedBy constrainedBy);
    UUID create(Require require);
    UUID create(ForcedBy forcedBy);
    UUID create(JustifiedBy justifiedBy);
    UUID create(Has has);
}
