package ch.unisg.backend.controller.http.dto.response.ad;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;
import ch.unisg.backend.core.domain.entities.relationships.Has;

import java.util.HashMap;
import java.util.List;

public class AlternativeResponseDto extends ResponseDto {

    public static List<HashMap<String, Object>> toJson(List<Alternative> alternativeList) {
        return alternativeList.stream().map(AlternativeResponseDto::toJson).toList();
    }

    public static HashMap<String, Object> toJson(Alternative alternative) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", alternative.getId().toString());
        result.put("title", alternative.getTitle());
        result.put("influencedBy", InfluenceResponseDto.toJson(alternative.getInfluenceList()));

        return result;
    }

    public static HashMap<String, Object> toJsonWithRationale(Alternative alternative) {
        HashMap<String, Object> result = toJson(alternative);
        result.put("rationaleList", RationaleResponseDto.toJson(alternative.getRationaleList()));
        return result;
    }

}

