package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.controller.http.dto.response.ar.ConstraintResponseDto;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemElementResponseDto {

    public static HashMap<String, Object> toJson(SystemElement systemElement) {

        HashMap<String, Object> systemElementDto = new HashMap<>();

        systemElementDto.put("id", systemElement.getId().toString());
        systemElementDto.put("title", systemElement.getTitle());

        List<HashMap<String, Object>> constraintListDto = new ArrayList<>();

        systemElement.getConstraintList().forEach(constraint -> {
            constraintListDto.add(ConstraintResponseDto.create(constraint));
        });

        systemElementDto.put("constraintList", constraintListDto);

        return systemElementDto;
    }
}
