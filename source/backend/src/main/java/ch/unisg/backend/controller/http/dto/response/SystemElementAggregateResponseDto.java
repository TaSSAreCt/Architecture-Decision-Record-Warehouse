package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.controller.http.dto.response.ar.ConstraintResponseDto;
import ch.unisg.backend.core.domain.aggregate.SystemElementAggregate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemElementAggregateResponseDto {

    public static HashMap<String, Object> toJson(SystemElementAggregate systemElementAggregate) {
        HashMap<String, Object> systemElementAggregateDto = new HashMap<>();

        systemElementAggregateDto.put("id", systemElementAggregate.getSystemElement().getId().toString());
        systemElementAggregateDto.put("title", systemElementAggregate.getSystemElement().getTitle());

        List<HashMap<String, Object>> constraintsDto = new ArrayList<>();

        systemElementAggregate.getConstraintList().forEach(constraint -> {
            constraintsDto.add(ConstraintResponseDto.create(constraint));
        });

        systemElementAggregateDto.put("constraints", constraintsDto);

        return systemElementAggregateDto;
    }
}
