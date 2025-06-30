package ch.unisg.sat.infrastructure.repository.mapper;

import ch.unisg.sat.core.domain.aggregate.SystemElementAggregate;
import ch.unisg.sat.infrastructure.repository.sdn.node.SystemElementNode;

public class SystemElementAggregateMapper {

    public static SystemElementAggregate toSystemElementAggregate(SystemElementNode systemElementNode) {

        SystemElementAggregate systemElementAggregate = SystemElementAggregate.create();

        return systemElementAggregate;

    }
}
