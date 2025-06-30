import {ForcedByRequestDto} from "$lib/dto/request/relationship/ForcedByRequestDto";
import {AlternativeAggregate} from "$lib/domain/aggregate/AlternativeAggregate.svelte";

export class AlternativeAggregateRequestDto {
    id: string;
    title: string;
    architecturalRequirements: ForcedByRequestDto[] = [];

    constructor(id: string, title: string) {
        this.id = id;
        this.title = title;
    }

    static create(id : string, title : string) : AlternativeAggregateRequestDto {
        return new AlternativeAggregateRequestDto(id, title);
    }
}

export function toAlternativeAggregateRequestDto(alternativeAggregates : AlternativeAggregate[]) : AlternativeAggregateRequestDto[] {

    const alternativeAggregatesRequestDto : AlternativeAggregateRequestDto[] = [];

    alternativeAggregates.forEach(alternativeAggregate => {

        const alternativeAggregateRequestDto : AlternativeAggregateRequestDto = AlternativeAggregateRequestDto.create(
            alternativeAggregate.alternative.id,
            alternativeAggregate.alternative.title
        );

        alternativeAggregate.forcedBy.forEach(f => {
            alternativeAggregateRequestDto.architecturalRequirements.push(
                ForcedByRequestDto.create(
                    f.architectureRequirement.value.id,
                    f.architectureRequirement.value.title,
                    f.architectureRequirement.type,
                    f.impact
                )
            );
        });

        alternativeAggregatesRequestDto.push(alternativeAggregateRequestDto);
    });

    return alternativeAggregatesRequestDto;
}