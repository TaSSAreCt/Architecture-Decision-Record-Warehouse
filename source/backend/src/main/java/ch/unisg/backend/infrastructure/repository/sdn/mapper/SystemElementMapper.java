package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;
import ch.unisg.backend.infrastructure.repository.sdn.node.ConstraintNode;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemElementNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SystemElementMapper {

    public static SystemElement toSystemElement(SystemElementNode systemElementNode) {
        return SystemElement.create(systemElementNode.getId(), systemElementNode.getTitle());
    }

    public static List<SystemElement> toSystemElementList(Set<SystemElementNode> systemElementNodes) {

        List<SystemElement> systemElementList = new ArrayList<>();

        systemElementNodes.forEach(systemElementNode -> {

            SystemElement systemElement = toSystemElement(systemElementNode);

            for (ConstraintNode constraintNode : systemElementNode.constraintNodes) {
                systemElement.getConstraintList().add(ConstraintMapper.toConstraint(constraintNode));
            }

            systemElementList.add(systemElement);

        });

        return systemElementList;
    }
}
