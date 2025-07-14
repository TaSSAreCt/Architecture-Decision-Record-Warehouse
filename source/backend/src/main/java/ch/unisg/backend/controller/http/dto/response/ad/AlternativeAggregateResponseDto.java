package ch.unisg.backend.controller.http.dto.response.ad;

import ch.unisg.backend.controller.http.dto.response.ResponseDto;
import ch.unisg.backend.controller.http.dto.response.ar.ArchitecturalRequirementsResponseDto;
import ch.unisg.backend.controller.http.dto.response.ar.ForcedByResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class AlternativeAggregateResponseDto extends ResponseDto {

    private UUID id;
    private String title;
    private ForcedByResponseDto[] forcedBy;
    private ArchitectureRationaleResponseDto[] architectureRationales;

    private AlternativeAggregateResponseDto() {

    }

    static public AlternativeAggregateResponseDto create() {
        return new AlternativeAggregateResponseDto();
    }

    public HashMap<String, Object> toJson() {
        HashMap<String, Object> alternativeResponseDto = new HashMap<>();

        alternativeResponseDto.put("id", this.id);
        alternativeResponseDto.put("title", this.title);
        alternativeResponseDto.put("forcedBy", this.forcedBy);
        alternativeResponseDto.put("architectureRationale", this.architectureRationales);

        return alternativeResponseDto;

    }

    public static HashMap<String, Object> toJsonVerbose(AlternativeAggregate alternativeAggregate) {

        HashMap<String, Object> alternative = new HashMap<>();

        alternative.put("alternative", AlternativeResponseDto.toJson(alternativeAggregate.getAlternative()));
        alternative.put("forcedBy", ArchitecturalRequirementsResponseDto.toJson(alternativeAggregate.getForcedBy()));
        alternative.put("architectureRationales", ArchitectureRationaleResponseDto.toJson(alternativeAggregate.getArchitectureRationales()));

        return alternative;

    }

    public static List<HashMap<String, Object>> toJsonVerbose(List<AlternativeAggregate> alternativeAggregates) {

        List<HashMap<String, Object>> alternatives = new ArrayList<>();

        alternativeAggregates.forEach(alternativeAggregate -> {
            alternatives.add(toJsonVerbose(alternativeAggregate));
        });

        return alternatives;

    }

}
