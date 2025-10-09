package ch.unisg.backend.controller.http.dto.response.cpsos;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.controller.http.dto.response.ar.ConstraintResponseDto;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemElement;

import java.util.HashMap;
import java.util.List;

public class SystemElementResponseDto extends ResponseDto {

  public static HashMap<String, Object> toJson(SystemElement systemElement) {

    HashMap<String, Object> systemElementResponseDto = new HashMap<>();

    systemElementResponseDto.put("id", systemElement.getId().toString());
    systemElementResponseDto.put("title", systemElement.getTitle());
    systemElementResponseDto.put("isCyber", systemElement.isCyber());
    systemElementResponseDto.put("constraintList", ConstraintResponseDto.toJson(systemElement.getConstraintList()));

    return systemElementResponseDto;
  }

  public static List<HashMap<String, Object>> toJson(List<SystemElement> systemElementList) {
    return systemElementList.stream().map(SystemElementResponseDto::toJson).toList();
  }

}
