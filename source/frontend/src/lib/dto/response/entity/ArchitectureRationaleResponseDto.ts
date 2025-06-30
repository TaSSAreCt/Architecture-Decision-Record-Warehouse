import {ArchitectureRationale} from "$lib/domain/entity/ad/ArchitectureRationale.svelte.js";

export class ArchitectureRationaleResponseDto {
    id : string = "";
    title : string = "";
    context : string = "";
    decision : string = "";
    status : string = "";
    consequences : string = "";
}

export function fromArchitectureRationaleResponseDto(architectureRationaleResponseDto : ArchitectureRationaleResponseDto) : ArchitectureRationale {
    const architectureRationale : ArchitectureRationale = ArchitectureRationale.create();

    architectureRationale.id = architectureRationaleResponseDto.id;
    architectureRationale.title = architectureRationaleResponseDto.title;
    architectureRationale.context = architectureRationaleResponseDto.context;
    architectureRationale.decision = architectureRationaleResponseDto.decision;
    architectureRationale.status = architectureRationaleResponseDto.status;
    architectureRationale.consequences = architectureRationaleResponseDto.consequences;

    return architectureRationale;
}

export function fromArchitectureRationalesResponseDto(architecturalRationalesResponseDto : ArchitectureRationaleResponseDto[]) : ArchitectureRationale[] {
    return architecturalRationalesResponseDto.map(fromArchitectureRationaleResponseDto);
}
