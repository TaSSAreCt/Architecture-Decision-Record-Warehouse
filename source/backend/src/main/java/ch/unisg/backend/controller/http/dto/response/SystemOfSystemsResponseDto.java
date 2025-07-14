package ch.unisg.backend.controller.http.dto.response;

import ch.unisg.backend.controller.http.dto.response.ar.NonFunctionalRequirementListResponseDto;
import ch.unisg.backend.controller.http.dto.response.cpsos.SystemClassResponseDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemOfSystemsResponseDto extends ResponseDto {

    public static HashMap<String, Object> toJson(SystemOfSystems systemOfSystems) {
        return buildSystemMap(systemOfSystems);
    }

    private static HashMap<String, Object> buildSystemMap(SystemOfSystems systemOfSystems) {
        HashMap<String, Object> systemMap = new HashMap<>();

        if (systemOfSystems == null || systemOfSystems.getSystemClass() == null) {
            return systemMap;
        }

        systemMap.put("system", SystemClassResponseDto.toJson(systemOfSystems.getSystemClass().getId(), systemOfSystems.getSystemClass().getTitle()));
        systemMap.put("issueList", ArchitecturalDecisionsResponseDto.toJsonVerbose(systemOfSystems.getArchitecturalDecisions()));
        systemMap.put("nonFunctionalRequirementList", NonFunctionalRequirementListResponseDto.toJsonVerbose(systemOfSystems.getNonFunctionalRequirements()));
        systemMap.put("systemElementList", SystemElementListResponseDto.toJson(systemOfSystems.getSystemElementAggregateList()));

        List<HashMap<String, Object>> childSystems = new ArrayList<>();
        for (SystemOfSystems child : systemOfSystems.getSystemOfSystemsList()) {
            childSystems.add(buildSystemMap(child));
        }
        if (!childSystems.isEmpty()) {
            systemMap.put("systemList", childSystems);
        } else {
            systemMap.put("systemList", new ArrayList<>());
        }

        return systemMap;
    }

}
