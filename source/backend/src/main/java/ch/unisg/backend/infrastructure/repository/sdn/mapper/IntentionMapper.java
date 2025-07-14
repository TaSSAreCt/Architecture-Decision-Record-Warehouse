package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ar.Intention;
import ch.unisg.backend.infrastructure.repository.sdn.node.IntentionNode;

public class IntentionMapper {

    public static Intention toIntention(IntentionNode intentionNode) {
        return Intention.create(intentionNode.getId(), intentionNode.getTitle());
    }
}
