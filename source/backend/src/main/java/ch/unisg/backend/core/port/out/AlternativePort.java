package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;

public interface AlternativePort {
    void createAlternative(Alternative alternative);
    Alternative readAlternativeById(Alternative alternative);
}