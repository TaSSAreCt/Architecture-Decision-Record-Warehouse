import {
    ArchitectureRequirementResponseDto,
    fromArchitectureRequirementResponseDto
} from "$lib/dto/response/entity/ArchitectureRequirementResponseDto";
import {Influence} from "$lib/domain/entity/ad/Influence.svelte";

export class InfluenceResponseDto {
    id : string | undefined;
    value : number | undefined;
    architectureRequirement : ArchitectureRequirementResponseDto | undefined;

    static create() {
        return new InfluenceResponseDto();
    }
}

export function fromInfluenceListResponseDto(influenceListResponseDto : InfluenceResponseDto[]) : Influence[] {
    return influenceListResponseDto.map(fromInfluenceResponseDto);
}

export function fromInfluenceResponseDto(influenceResponseDto : InfluenceResponseDto) : Influence {
    const influence : Influence = Influence.create();

    influence.id = influenceResponseDto.id ?? "";
    influence.value = influenceResponseDto.value ?? 0.0;

    if (influenceResponseDto.architectureRequirement) {
        influence.architectureRequirement = fromArchitectureRequirementResponseDto(influenceResponseDto.architectureRequirement);
    }

    return influence;
}
