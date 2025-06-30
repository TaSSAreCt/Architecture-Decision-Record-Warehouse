package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.entities.classes.ad.Alternative;

import java.util.UUID;

public interface AlternativePort {
    void createAlternative(Alternative alternative);
    Alternative readAlternativeById(Alternative alternative);
}