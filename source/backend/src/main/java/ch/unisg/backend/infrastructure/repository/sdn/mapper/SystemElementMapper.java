package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.backend.infrastructure.repository.sdn.node.ConstraintNode;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemElementNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SystemElementMapper {

    public static SystemElement toSystemElement(SystemElementNode systemElementNode) {

        SystemElement systemElement = SystemElement.create(systemElementNode.getId(), systemElementNode.getTitle());

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
