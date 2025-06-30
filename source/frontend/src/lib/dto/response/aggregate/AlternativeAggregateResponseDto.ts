import {ForcedByResponseDto, fromForcedByListResponseDto} from "$lib/dto/response/relationship/ForcedByResponseDto";
import {
    ArchitectureRationaleResponseDto,
    fromArchitectureRationalesResponseDto
} from "$lib/dto/response/entity/ArchitectureRationaleResponseDto";
import {AlternativeResponseDto, fromAlternativeResponseDto} from "$lib/dto/response/entity/AlternativeResponseDto";
import {AlternativeAggregate} from "$lib/domain/aggregate/AlternativeAggregate.svelte";

export class AlternativeAggregateResponseDto {
    alternative : AlternativeResponseDto = AlternativeResponseDto.create();
    forcedBy: ForcedByResponseDto[] = [];
    architectureRationales: ArchitectureRationaleResponseDto[] = [];

    constructor() {}
}

export function fromAlternativeAggregatesResponseDto(alternativeAggregatesResponseDto : AlternativeAggregateResponseDto[]) : AlternativeAggregate[] {
    return alternativeAggregatesResponseDto.map(fromAlternativeAggregateResponseDto);

}

export function fromAlternativeAggregateResponseDto(alternativeAggregateResponseDto : AlternativeAggregateResponseDto) : AlternativeAggregate {
    const alternativeAggregate : AlternativeAggregate = AlternativeAggregate.create();

    alternativeAggregate.alternative = fromAlternativeResponseDto(alternativeAggregateResponseDto.alternative);

    alternativeAggregate.forcedBy = fromForcedByListResponseDto(alternativeAggregateResponseDto.forcedBy);

    alternativeAggregate.architectureRationales = fromArchitectureRationalesResponseDto(alternativeAggregateResponseDto.architectureRationales);

    return alternativeAggregate;
}


