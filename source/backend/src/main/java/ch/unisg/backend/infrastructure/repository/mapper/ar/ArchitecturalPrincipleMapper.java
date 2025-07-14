package ch.unisg.backend.infrastructure.repository.mapper.ar;

import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.backend.infrastructure.repository.sdn.node.ArchitecturePrincipleNode;

public class ArchitecturalPrincipleMapper {

    public static ArchitecturePrinciple toArchitecturalPrinciple(ArchitecturePrincipleNode architecturePrincipleNode) {
        return ArchitecturePrinciple.create(architecturePrincipleNode.getId(), architecturePrincipleNode.getTitle());
    }
}
