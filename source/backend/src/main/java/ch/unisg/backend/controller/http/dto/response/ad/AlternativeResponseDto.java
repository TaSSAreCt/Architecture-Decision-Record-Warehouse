package ch.unisg.backend.controller.http.dto.response.ad;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;

import java.util.HashMap;

public class AlternativeResponseDto extends ResponseDto {

    public static HashMap<String, Object> toJson(Alternative alternative) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", alternative.getId().toString());
        result.put("title", alternative.getTitle());

        // TODO: Implement influence

        return result;
    }

    public static HashMap<String, Object> toJsonWithRationale(Alternative alternative) {
        HashMap<String, Object> result = toJson(alternative);
        result.put("rationaleList", RationaleResponseDto.toJson(alternative.getRationaleList()));
        return result;
    }

}

