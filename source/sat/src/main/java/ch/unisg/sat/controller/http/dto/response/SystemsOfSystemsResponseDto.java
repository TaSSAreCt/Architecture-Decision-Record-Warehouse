package ch.unisg.sat.controller.http.dto.response;

import ch.unisg.sat.core.domain.aggregate.SystemOfSystems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 *
 */
public class SystemsOfSystemsResponseDto extends ResponseDto{

    /**
     *
     *
     */
    public static List<HashMap<String, Object>> toJson(List<SystemOfSystems> systemsOfSystems) {
        List<HashMap<String, Object>> systemsOfSystemsDto = new ArrayList<>();

        for (SystemOfSystems systemOfSystem : systemsOfSystems) {
            HashMap<String, Object> systemMap = buildSystemMap(systemOfSystem);
            systemsOfSystemsDto.add(systemMap);
        }

        return systemsOfSystemsDto;
    }

    /**
     *
     *
     */
    private static HashMap<String, Object> buildSystemMap(SystemOfSystems systemOfSystems) {
        HashMap<String, Object> systemMap = new HashMap<>();

        if (systemOfSystems == null || systemOfSystems.getSystemClass() == null) {
            return systemMap;
        }

        systemMap.put("id", systemOfSystems.getSystemClass().getId().toString());
        systemMap.put("title", systemOfSystems.getSystemClass().getTitle());

        List<HashMap<String, Object>> childSystems = new ArrayList<>();

        for (SystemOfSystems child : systemOfSystems.getSystemOfSystemsList()) {
            childSystems.add(buildSystemMap(child));
        }

        if (!childSystems.isEmpty()) {
            systemMap.put("childSystems", childSystems);
        }

        return systemMap;
    }
}
