import {Rationale} from "$lib/domain/entity/ad/Rationale.svelte";

export class RationaleResponseDto {
    id : string = "";
    title : string = "";
    context : string = "";
    decision : string = "";
    status : string = "";
    consequences : string = "";
    justifies : string = "";
}

export function fromRationalesResponseDto(
    architecturalRationalesResponseDto : RationaleResponseDto[]
) : Rationale[] {
    return architecturalRationalesResponseDto.map(fromRationaleResponseDto);
}

export function fromRationaleResponseDto(
    rationaleResponseDto : RationaleResponseDto
) : Rationale {
    const rationale : Rationale = Rationale.create();

    rationale.id = rationaleResponseDto.id;
    rationale.title = rationaleResponseDto.title;
    rationale.context = rationaleResponseDto.context;
    rationale.decision = rationaleResponseDto.decision;
    rationale.status = rationaleResponseDto.status;
    rationale.consequences = rationaleResponseDto.consequences;
    rationale.justifies = rationaleResponseDto.justifies;

    return rationale;
}