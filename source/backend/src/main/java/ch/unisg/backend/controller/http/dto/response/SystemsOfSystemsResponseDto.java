package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;

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
    public static List<HashMap<String, Object>> toJson(List<SystemClass> systemsOfSystems) {
        List<HashMap<String, Object>> systemsOfSystemsDto = new ArrayList<>();

        for (SystemClass systemOfSystem : systemsOfSystems) {
            HashMap<String, Object> systemMap = buildSystemMap(systemOfSystem);
            systemsOfSystemsDto.add(systemMap);
        }

        return systemsOfSystemsDto;
    }

    /**
     *
     *
     */
    private static HashMap<String, Object> buildSystemMap(SystemClass systemOfSystems) {
        HashMap<String, Object> systemMap = new HashMap<>();

        if (systemOfSystems == null) {
            return systemMap;
        }

        systemMap.put("id", systemOfSystems.getId().toString());
        systemMap.put("title", systemOfSystems.getTitle());

        List<HashMap<String, Object>> childSystems = new ArrayList<>();

        for (SystemClass child : systemOfSystems.getSystemList()) {
            childSystems.add(buildSystemMap(child));
        }

        if (!childSystems.isEmpty()) {
            systemMap.put("childSystems", childSystems);
        }

        return systemMap;
    }
}
