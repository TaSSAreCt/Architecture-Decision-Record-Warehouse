package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemNode;

public class SystemMapper {

    public static SystemClass toSystem(SystemNode systemNode) {
        return SystemClass.create(systemNode.getId(), systemNode.getTitle());
    }
}
