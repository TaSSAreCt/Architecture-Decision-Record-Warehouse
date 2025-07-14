import {Madr} from "$lib/domain/entity/ad/M-adr.svelte";

export class MadrRationaleResponseDto {
    id : string = "";
    title : string = "";
    context : string = "";
    decision : string = "";
    status : string = "";
    consequences : string = "";
}

export function fromMadrRationalesResponseDto(
    architecturalRationalesResponseDto : MadrRationaleResponseDto[]
) : Madr[] {
    return architecturalRationalesResponseDto.map(fromMadrRationaleResponseDto);
}

export function fromMadrRationaleResponseDto(
    madrRationaleResponseDto : MadrRationaleResponseDto
) : Madr {
    const rationale : Madr = Madr.create();

    rationale.id = madrRationaleResponseDto.id;
    rationale.title = madrRationaleResponseDto.title;
    rationale.context = madrRationaleResponseDto.context;
    rationale.decision = madrRationaleResponseDto.decision;
    rationale.status = madrRationaleResponseDto.status;
    rationale.consequences = madrRationaleResponseDto.consequences;

    return rationale;
}