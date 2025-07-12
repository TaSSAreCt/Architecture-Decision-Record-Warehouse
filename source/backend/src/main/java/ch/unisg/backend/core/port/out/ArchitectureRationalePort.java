package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ad.ArchitectureRationale;

public interface ArchitectureRationalePort {

    void create(ArchitectureRationale architectureRationale);
    ArchitectureRationale readById(ArchitectureRationale architectureRationale);
}
