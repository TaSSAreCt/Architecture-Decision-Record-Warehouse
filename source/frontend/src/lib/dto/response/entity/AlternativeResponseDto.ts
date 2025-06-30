import {Alternative} from "$lib/domain/entity/ad/Alternative.svelte.js";

export class AlternativeResponseDto {
    id : string = "";
    title : string = "";

    static create() {
        return new Alternative();
    }
}

export function fromAlternativeResponseDto(alternativeResponseDto : AlternativeResponseDto) : Alternative {
    const alternative : Alternative = Alternative.create();

    alternative.id = alternativeResponseDto.id;
    alternative.title = alternativeResponseDto.title;

    return alternative;
}