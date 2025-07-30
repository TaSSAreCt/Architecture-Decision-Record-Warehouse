import {
    ConstraintResponseDto,
    fromConstraintListResponseDto,
} from "$lib/dto/response/entity/ConstraintResponseDto";
import {SystemElement} from "$lib/domain/entity/sos/SystemElement.svelte";

export class SystemElementResponseDto {
    id : string | undefined;
    title : string | undefined;
    constraintList : ConstraintResponseDto[] = [] ;

    constructor() {}
}

export function fromSystemElementListResponseDto(systemElementResponseDto: SystemElementResponseDto[]) : SystemElement[] {
    return systemElementResponseDto.map(fromSystemElementResponseDto);
}

export function fromSystemElementResponseDto(systemElementResponseDto : SystemElementResponseDto) : SystemElement {
    const systemElement : SystemElement = SystemElement.create();

    systemElement.id = systemElementResponseDto.id;
    systemElement.title = systemElementResponseDto.title;

    systemElement.constraintList = fromConstraintListResponseDto(systemElementResponseDto.constraintList);

    return systemElement;
}