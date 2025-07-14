package ch.unisg.backend.infrastructure.repository.mapper;

import ch.unisg.backend.core.domain.aggregate.SystemElementAggregate;
import ch.unisg.backend.core.domain.entities.classes.ar.Constraint;
import ch.unisg.backend.infrastructure.repository.mapper.sos.SystemElementMapper;
import ch.unisg.backend.infrastructure.repository.sdn.node.ConstraintNode;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemElementNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class SystemElementAggregateListMapper {

    public static Collection<SystemElementAggregate> toSystemElementAggregate(Set<SystemElementNode> systemElementNodes) {

        Collection<SystemElementAggregate> systemElementAggregates = new ArrayList<>();

        systemElementNodes.forEach(systemElementNode -> {
            SystemElementAggregate systemElementAggregate = SystemElementAggregate.create();

            systemElementAggregate.setSystemElement(SystemElementMapper.toSystemElement(systemElementNode));

            for (ConstraintNode constraintNode : systemElementNode.constraintNodes) {
                systemElementAggregate.getConstraintList().add(Constraint.create(constraintNode.getId(), constraintNode.getTitle()));
            }

            systemElementAggregates.add(systemElementAggregate);

        });
        return systemElementAggregates;
    }
}
