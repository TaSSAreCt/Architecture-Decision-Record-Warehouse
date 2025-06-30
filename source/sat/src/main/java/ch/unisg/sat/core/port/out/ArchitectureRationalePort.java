package ch.unisg.sat.core.port.out;

import ch.unisg.sat.core.domain.entities.classes.ad.ArchitectureRationale;

public interface ArchitectureRationalePort {

    void create(ArchitectureRationale architectureRationale);
    ArchitectureRationale readById(ArchitectureRationale architectureRationale);
}
