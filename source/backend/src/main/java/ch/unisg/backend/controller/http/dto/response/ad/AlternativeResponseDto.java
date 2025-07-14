package ch.unisg.backend.controller.http.dto.response.ad;

import ch.unisg.backend.controller.http.dto.response.ar.ArchitectureRequirementResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ad.Alternative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AlternativeResponseDto {

    public static HashMap<String, Object> toJson(Alternative alternative) {
        HashMap<String, Object> result = new HashMap<>();

        result.put("id", alternative.getId().toString());
        result.put("title", alternative.getTitle());

        return result;
    }

    public static HashMap<String, Object> create(Alternative alternative) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", alternative.getId().toString());
        result.put("title", alternative.getTitle());

        List<HashMap<String, Object>> architecturalRequirementDto = new ArrayList<>();

        if (!alternative.getArchitectureRequirements().isEmpty()) {

            AtomicInteger value = new AtomicInteger();

            alternative.getArchitectureRequirements().forEach(architectureRequirement -> {

                value.addAndGet(architectureRequirement.getValue());

                architecturalRequirementDto.add(ArchitectureRequirementResponseDto.toJson(architectureRequirement));

            });

            result.put("value", value);
            result.put("architectureRequirement", architecturalRequirementDto);
        }

        return result;
    }
}

