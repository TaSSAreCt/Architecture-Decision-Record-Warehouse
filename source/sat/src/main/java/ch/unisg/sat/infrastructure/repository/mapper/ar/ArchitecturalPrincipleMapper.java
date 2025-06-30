package ch.unisg.sat.infrastructure.repository.mapper.ar;

import ch.unisg.sat.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.sat.infrastructure.repository.sdn.node.ArchitecturePrincipleNode;

public class ArchitecturalPrincipleMapper {

    public static ArchitecturePrinciple toArchitecturalPrinciple(ArchitecturePrincipleNode architecturePrincipleNode) {
        return ArchitecturePrinciple.create(architecturePrincipleNode.getId(), architecturePrincipleNode.getTitle());
    }
}
