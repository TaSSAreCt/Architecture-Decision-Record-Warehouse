package ch.unisg.backend.infrastructure.repository.mapper;

import ch.unisg.backend.core.domain.aggregate.SystemElementAggregate;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemElementNode;

public class SystemElementAggregateMapper {

    public static SystemElementAggregate toSystemElementAggregate(SystemElementNode systemElementNode) {

        SystemElementAggregate systemElementAggregate = SystemElementAggregate.create();

        return systemElementAggregate;

    }
}
