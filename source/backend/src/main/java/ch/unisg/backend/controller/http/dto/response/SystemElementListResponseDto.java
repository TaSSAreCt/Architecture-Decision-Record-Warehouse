package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemElementListResponseDto extends ResponseDto{

    public static List<HashMap<String, Object>> toJson(List<SystemElement> systemElementList) {
        List<HashMap<String, Object>> systemElementAggregatesDto = new ArrayList<>();

        systemElementList.forEach(systemElement -> {
            systemElementAggregatesDto.add(SystemElementResponseDto.toJson(systemElement));
        });

        return systemElementAggregatesDto;
    }
}
