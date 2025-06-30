package ch.unisg.sat.infrastructure.repository.mapper.ar;

import ch.unisg.sat.core.domain.entities.classes.ar.Intention;
import ch.unisg.sat.infrastructure.repository.sdn.node.IntentionNode;

public class IntentionMapper {

    public static Intention toIntention(IntentionNode intentionNode) {
        return Intention.create(intentionNode.getId(), intentionNode.getTitle());
    }
}
