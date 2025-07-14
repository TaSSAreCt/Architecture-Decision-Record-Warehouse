package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ar.Intention;

import java.util.List;

public interface IntentionPort {
    void create(Intention intention);
    Intention readById(Intention intention);
    void readAll(List<Intention> intentionList);
}
