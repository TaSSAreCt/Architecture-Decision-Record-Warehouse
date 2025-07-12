package ch.unisg.backend.core.port.out;

import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturePrinciple;

import java.util.List;

public interface ArchitecturePrinciplePort {
    void create(ArchitecturePrinciple architecturePrinciple);
    ArchitecturePrinciple findById(ArchitecturePrinciple architecturePrinciple);
    void readAll(List<ArchitecturePrinciple> architecturePrincipleList);
}
