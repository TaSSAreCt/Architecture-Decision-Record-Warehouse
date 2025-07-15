package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ar.Intention;
import ch.unisg.backend.infrastructure.repository.sdn.node.IntentionNode;

import java.util.List;

public class IntentionMapper {

    public static Intention toIntention(IntentionNode intentionNode) {
        return Intention.create(intentionNode.getId(), intentionNode.getTitle());
    }

    public static List<Intention> toIntentionList(List<IntentionNode> intentionNodeList) {
        return intentionNodeList.stream().map(IntentionMapper::toIntention).toList();
    }
}
