package ch.unisg.backend.controller.http.dto.response.ad;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ad.Rationale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RationaleResponseDto extends ResponseDto {

    public static HashMap<String, Object> toJson(Rationale rationale) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", rationale.getId());
        result.put("title", rationale.getTitle());
        result.put("context", rationale.getContext());
        result.put("decision", rationale.getDecision());
        result.put("status", rationale.getStatus());
        result.put("consequences", rationale.getConsequences());
        result.put("justifies", rationale.getAlternative().getId());

        return result;
    }

    public static List<HashMap<String, Object>> toJson(List<Rationale> rationales) {
        return rationales.stream().map(RationaleResponseDto::toJson).toList();
    }
}
