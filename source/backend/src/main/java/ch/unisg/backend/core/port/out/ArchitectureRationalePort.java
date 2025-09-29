package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;

public interface ArchitectureRationalePort {

    void create(Rationale architectureRationale);
    Rationale readById(Rationale architectureRationale);
}
