package ch.unisg.backend.controller.http.dto.response.cpsos;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.controller.http.dto.response.ad.IssueResponseDto;
import ch.unisg.backend.controller.http.dto.response.ad.RationaleResponseDto;
import ch.unisg.backend.controller.http.dto.response.ar.NonFunctionalRequirementResponseDto;
import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter
public class SystemClassResponseDto extends ResponseDto {
    private final UUID id;
    private final String title;

    private SystemClassResponseDto(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public static HashMap<String, Object> toJson(SystemClass systemClass) {
        HashMap <String, Object> result = new HashMap<>();
        result.put("id", systemClass.getId());
        result.put("title", systemClass.getTitle());
        result.put("issueList", IssueResponseDto.toJson(systemClass.getIssueList()));
        result.put("nonFunctionalRequirementList", NonFunctionalRequirementResponseDto.toNonFunctionalRequirementResponseDtoList(systemClass.getNonFunctionalRequirementList()));
        result.put("systemElementList", SystemElementResponseDto.toJson(systemClass.getSystemElementList()));
        result.put("rationaleList", RationaleResponseDto.toJson(systemClass.getRationaleList()));

        List<HashMap<String, Object>> childSystems = new ArrayList<>();
        for (SystemClass child : systemClass.getSystemList()) {
            childSystems.add(toJson(child));
        }
        if (!childSystems.isEmpty()) {
            result.put("systemList", childSystems);
        } else {
            result.put("systemList", new ArrayList<>());
        }

        return result;
    }

    public static List<HashMap<String, Object>> toJson(List<SystemClass> systemClassList) {
        return systemClassList.stream().map(SystemClassResponseDto::toJson).toList();
    }
}
