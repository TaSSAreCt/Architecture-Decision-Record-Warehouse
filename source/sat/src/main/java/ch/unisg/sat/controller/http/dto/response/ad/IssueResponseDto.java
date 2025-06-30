package ch.unisg.sat.controller.http.dto.response.ad;

import ch.unisg.sat.core.domain.entities.classes.ad.Issue;

import java.util.HashMap;

public class IssueResponseDto {

    public static HashMap<String, Object> toJson(Issue issue) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", issue.getId().toString());
        result.put("title", issue.getTitle());

        return result;
    }
}
