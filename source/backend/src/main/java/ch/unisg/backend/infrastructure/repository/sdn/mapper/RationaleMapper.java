package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;
import ch.unisg.backend.infrastructure.repository.sdn.node.RationaleNode;

import java.util.List;

public class RationaleMapper {

    public static List<Rationale> toRationaleList(List<RationaleNode> rationaleNodeList) {
        return rationaleNodeList.stream().map(RationaleMapper::toRationale).toList();
    }

    public static Rationale toRationale(RationaleNode architectureRationaleNode) {
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
