import {ConstraintResponseDto, fromConstraintsResponseDto} from "$lib/dto/response/entity/ConstraintResponseDto";
import {SystemElementAggregate} from "$lib/domain/aggregate/SystemElementAggregate.svelte";

export class SystemElementAggregateResponseDto {
    id : string = "";
    title : string = "";
    constraints : ConstraintResponseDto[] = [] ;

    constructor() {}
}

export function fromSystemElementAggregatesResponseDto(systemElementAggregatesResponseDto: SystemElementAggregateResponseDto[]) : SystemElementAggregate[] {
    return systemElementAggregatesResponseDto.map(fromSystemElementAggregateResponseDto);
}

export function fromSystemElementAggregateResponseDto(systemElementAggregateResponseDto : SystemElementAggregateResponseDto) : SystemElementAggregate {
    const systemElementAggregate : SystemElementAggregate = SystemElementAggregate.create();

    systemElementAggregate.id = systemElementAggregateResponseDto.id;
    systemElementAggregate.title = systemElementAggregateResponseDto.title;

    systemElementAggregate.constraints = fromConstraintsResponseDto(systemElementAggregateResponseDto.constraints);

    return systemElementAggregate;
}