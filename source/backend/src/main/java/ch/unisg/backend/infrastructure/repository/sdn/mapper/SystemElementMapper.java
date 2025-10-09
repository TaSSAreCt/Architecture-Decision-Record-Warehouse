package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemElementNode;

import java.util.List;

public class SystemElementMapper {

  public static SystemElement toSystemElement(SystemElementNode systemElementNode) {

    SystemElement systemElement = SystemElement.create(systemElementNode.getId(), systemElementNode.getTitle(),
        systemElementNode.isCyber());

    systemElement.getConstraintList().addAll(ConstraintMapper.toConstraintList(systemElementNode.constraintNodes));

    return systemElement;
  }

  public static List<SystemElement> toSystemElementList(List<SystemElementNode> systemElementNodes) {
    return systemElementNodes
        .stream()
        .map(SystemElementMapper::toSystemElement)
        .toList();
  }
}
