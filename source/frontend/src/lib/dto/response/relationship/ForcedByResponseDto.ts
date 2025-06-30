import {
    ArchitectureRequirementResponseDto,
    fromArchitectureRequirementResponseDto
} from "$lib/dto/response/entity/ArchitectureRequirementResponseDto";
import {ForcedBy} from "$lib/domain/aggregate/ForcedBy.svelte.js";

export class ForcedByResponseDto {
    id: string = "";
    value: number = 0;
    architectureRequirement: ArchitectureRequirementResponseDto = ArchitectureRequirementResponseDto.create();

    constructor() {}
}

export function fromForcedByListResponseDto(forcedByListResponseDto : ForcedByResponseDto[]) : ForcedBy[] {
    return forcedByListResponseDto.map(fromForcedByResponseDto);

}

export function fromForcedByResponseDto(forcedByResponseDto : ForcedByResponseDto) : ForcedBy {
    return ForcedBy.create(fromArchitectureRequirementResponseDto(forcedByResponseDto.architectureRequirement), forcedByResponseDto.value);
}