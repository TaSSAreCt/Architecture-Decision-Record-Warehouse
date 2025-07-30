package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.infrastructure.repository.sdn.node.AlternativeNode;

import java.util.List;

public class AlternativeMapper {

    public static List<Alternative> toAlternativeList(List<AlternativeNode> alternativeNodeList) {
        return alternativeNodeList.stream().map(AlternativeMapper::toAlternative).toList();
    }

    public static Alternative toAlternative(AlternativeNode alternativeNode) {

        Alternative alternative = Alternative.create(alternativeNode.getId(), alternativeNode.getTitle());
        alternative.getInfluenceList().addAll(InfluenceMapper.toInfluenceList(alternativeNode.getInfluenceNodeList()));

        return alternative;
    }
}
