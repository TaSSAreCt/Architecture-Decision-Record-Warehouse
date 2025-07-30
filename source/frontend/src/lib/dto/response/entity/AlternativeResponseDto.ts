import {Alternative} from "$lib/domain/entity/ad/Alternative.svelte.js";
import {fromInfluenceListResponseDto, InfluenceResponseDto} from "$lib/dto/response/entity/InfluenceResponseDto";

export class AlternativeResponseDto {
    id : string | undefined;
    title : string | undefined;
    influencedBy : InfluenceResponseDto[] | undefined;

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

    if (alternativeResponseDto.influencedBy) {
        alternative.influenceList = fromInfluenceListResponseDto(alternativeResponseDto.influencedBy);
    }

    return alternative;
}


