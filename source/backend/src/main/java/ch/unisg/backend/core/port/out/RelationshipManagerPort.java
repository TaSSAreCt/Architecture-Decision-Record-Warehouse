package ch.unisg.backend.core.port.out;

import java.util.UUID;

public interface RelationshipManagerPort {
  void create(UUID id, Float value, UUID alternativeId, UUID architecturalRequirementId);

  UUID create(SolvedBy solvedBy);

  UUID create(Raise raise);

  UUID create(BelongsTo belongsTo);

  UUID create(PartOf partOf);

  UUID create(ConstrainedBy constrainedBy);

  UUID create(Require require);

  UUID create(JustifiedBy justifiedBy);

  UUID create(Has has);

  UUID create(CyberEdge edge);
}
