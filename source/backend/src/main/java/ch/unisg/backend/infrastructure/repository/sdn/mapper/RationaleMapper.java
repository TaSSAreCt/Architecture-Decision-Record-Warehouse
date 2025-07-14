package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import ch.unisg.backend.infrastructure.repository.sdn.node.ArchitectureRationaleNode;

public class RationaleMapper {

    public static Rationale toArchitectureRationale(ArchitectureRationaleNode architectureRationaleNode) {
        return Rationale.create(
                architectureRationaleNode.getId(),
                architectureRationaleNode.getTitle(),
                architectureRationaleNode.getContext(),
                architectureRationaleNode.getDecision(),
                architectureRationaleNode.getStatus(),
                architectureRationaleNode.getConsequences()
        );
    }
}
