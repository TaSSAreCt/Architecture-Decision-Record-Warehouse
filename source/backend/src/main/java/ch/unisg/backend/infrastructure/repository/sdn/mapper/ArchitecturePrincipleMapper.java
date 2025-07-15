package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ar.ArchitecturePrinciple;
import ch.unisg.backend.infrastructure.repository.sdn.node.ArchitecturePrincipleNode;

import java.util.List;

public class ArchitecturePrincipleMapper {

    public static ArchitecturePrinciple toArchitecturalPrinciple(ArchitecturePrincipleNode architecturePrincipleNode) {
        return ArchitecturePrinciple.create(architecturePrincipleNode.getId(), architecturePrincipleNode.getTitle());
    }

    public static List<ArchitecturePrinciple> toArchitecturePrincipleList(List<ArchitecturePrincipleNode> architecturePrincipleNodeList) {
        return architecturePrincipleNodeList.stream().map(ArchitecturePrincipleMapper::toArchitecturalPrinciple).toList();
    }
}
