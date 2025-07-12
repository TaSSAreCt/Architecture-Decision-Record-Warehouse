package ch.unisg.backend.infrastructure.repository.mapper.sos;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemElementNode;

public class SystemElementMapper {

    public static SystemElement toSystemElement(SystemElementNode systemElementNode) {
        return SystemElement.create(systemElementNode.getId(), systemElementNode.getTitle());
    }
}
