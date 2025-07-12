package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.core.domain.aggregate.SystemElementAggregate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemElementAggregateListResponseDto extends ResponseDto{

    public static List<HashMap<String, Object>> toJson(List<SystemElementAggregate> systemElementAggregates) {
        List<HashMap<String, Object>> systemElementAggregatesDto = new ArrayList<>();

        systemElementAggregates.forEach(systemElementAggregate -> {
            systemElementAggregatesDto.add(SystemElementAggregateResponseDto.toJson(systemElementAggregate));
        });

        return systemElementAggregatesDto;
    }
}
