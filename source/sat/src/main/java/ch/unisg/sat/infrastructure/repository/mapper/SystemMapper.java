package ch.unisg.sat.infrastructure.repository.mapper;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.sat.infrastructure.repository.sdn.node.SystemNode;

public class SystemMapper {

    public static SystemClass toSystem(SystemNode systemNode) {
        return SystemClass.create(systemNode.getId(), systemNode.getTitle());
    }
}
