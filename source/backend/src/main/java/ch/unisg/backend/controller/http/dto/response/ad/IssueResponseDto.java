package ch.unisg.backend.controller.http.dto.response.ad;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.core.domain.entities.classes.ad.Issue;

import java.util.HashMap;
import java.util.List;

public class IssueResponseDto extends ResponseDto {

    public static HashMap<String, Object> toJson(Issue issue) {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", issue.getId().toString());
        result.put("title", issue.getTitle());

        return result;
    }

    public static List<HashMap<String, Object>> toJson(List<Issue> issueList) {
        return issueList.stream().map(IssueResponseDto::toJson).toList();
    }
}
