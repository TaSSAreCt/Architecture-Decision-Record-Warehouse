package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;
import ch.unisg.sat.core.domain.entities.classes.ar.Intention;

import java.util.List;
import java.util.UUID;

public interface IntentionPort {
    void create(Intention intention);
    UUID force(Alternative alternative, Intention intention);
    Intention readById(Intention intention);
    void readAll(List<Intention> intentionList);
}
