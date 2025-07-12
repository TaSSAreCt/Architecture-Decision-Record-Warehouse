package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.domain.entities.classes.ar.Intention;

import java.util.List;
import java.util.UUID;

public interface IntentionPort {
    void create(Intention intention);
    UUID force(Alternative alternative, Intention intention);
    Intention readById(Intention intention);
    void readAll(List<Intention> intentionList);
}
