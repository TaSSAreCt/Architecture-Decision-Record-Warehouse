package ch.unisg.sat.infrastructure.repository.mapper.sos;

import ch.unisg.sat.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.sat.infrastructure.repository.sdn.node.SystemElementNode;

public class SystemElementMapper {

    public static SystemElement toSystemElement(SystemElementNode systemElementNode) {
        return SystemElement.create(systemElementNode.getId(), systemElementNode.getTitle());
    }
}
