import {Alternative} from "$lib/domain/entity/ad/Alternative.svelte.js";
import {
    fromMadrRationalesResponseDto,
    MadrRationaleResponseDto
} from "$lib/dto/response/entity/ArchitectureRationaleResponseDto";

export class AlternativeResponseDto {
    id : string | undefined;
    title : string | undefined;
    rationaleList : MadrRationaleResponseDto[] | undefined;

    static create() {
        return new Alternative();
    }
}

export function fromAlternativeListResponseDto(alternativeListResponseDto : AlternativeResponseDto[]) : Alternative[] {
    return alternativeListResponseDto.map(fromAlternativeResponseDto);

}

export function fromAlternativeResponseDto(alternativeResponseDto : AlternativeResponseDto) : Alternative {

    const alternative : Alternative = Alternative.create();

    alternative.id = alternativeResponseDto.id;
    alternative.title = alternativeResponseDto.title;

    if (alternativeResponseDto.rationaleList) {
        alternative.rationaleList = fromMadrRationalesResponseDto(alternativeResponseDto.rationaleList);
    }

    // TODO: Implement influence list

    return alternative;
}


