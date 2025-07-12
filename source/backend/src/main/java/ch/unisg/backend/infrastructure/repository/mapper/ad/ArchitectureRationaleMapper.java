package ch.unisg.backend.infrastructure.repository.mapper.ad;

import ch.unisg.backend.core.domain.entities.classes.ad.ArchitectureRationale;
import ch.unisg.backend.infrastructure.repository.sdn.node.ArchitectureRationaleNode;

public class ArchitectureRationaleMapper {

    public static ArchitectureRationale toArchitectureRationale(ArchitectureRationaleNode architectureRationaleNode) {
        return ArchitectureRationale.create(
                architectureRationaleNode.getId(),
                architectureRationaleNode.getTitle(),
                architectureRationaleNode.getContext(),
                architectureRationaleNode.getDecision(),
                architectureRationaleNode.getStatus(),
                architectureRationaleNode.getConsequences()
        );
    }
}
