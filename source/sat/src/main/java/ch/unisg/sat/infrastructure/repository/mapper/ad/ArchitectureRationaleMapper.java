package ch.unisg.sat.infrastructure.repository.mapper.ad;

import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;
import ch.unisg.sat.infrastructure.repository.sdn.node.ArchitectureRationaleNode;

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
