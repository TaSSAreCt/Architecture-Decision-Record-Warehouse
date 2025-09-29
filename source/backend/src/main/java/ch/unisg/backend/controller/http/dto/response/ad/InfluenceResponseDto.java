package ch.unisg.backend.controller.http.dto.response.ad;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.controller.http.dto.response.ar.ArchitectureRequirementResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ad.Influence;

import java.util.HashMap;
import java.util.List;

public class InfluenceResponseDto extends ResponseDto {
    public static List<HashMap<String, Object>> toJson(List<Influence> influenceList) {
        return influenceList.stream().map(InfluenceResponseDto::toJson).toList();
    }

    public static HashMap<String, Object> toJson(Influence influence) {
        HashMap<String, Object> result = new HashMap<>();

        result.put("id", influence.getId());
        result.put("value", influence.getValue());
        result.put("architectureRequirement", ArchitectureRequirementResponseDto.toJson(influence.getArchitectureRequirement()));

        return result;
    }

}
