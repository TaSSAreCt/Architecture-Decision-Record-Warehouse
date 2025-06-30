import {
    ArchitectureDecisionResponseDto,
    fromArchitecturalDecisionsResponseDto
} from "$lib/dto/response/aggregate/ArchitectureDecisionResponseDto";
import {
    fromSystemElementAggregatesResponseDto,
    SystemElementAggregateResponseDto
} from "$lib/dto/response/aggregate/SystemElementAggregateResponseDto";
import {
    fromNonFunctionalRequirementsResponseDto,
    NonFunctionalRequirementResponseDto
} from "$lib/dto/response/entity/NonFunctionalRequirementResponseDto";
import {SystemOfSystems} from "$lib/domain/aggregate/SystemOfSystems.svelte.js";
import {fromSystemResponseDto, SystemResponseDto} from "$lib/dto/response/entity/SystemResponseDto";

export class SystemOfSystemsResponseDto {

    system : SystemResponseDto = SystemResponseDto.create();
    systemElements : SystemElementAggregateResponseDto[] = [];
    childSystems : SystemOfSystemsResponseDto[] = [];
    architecturalDecisions : ArchitectureDecisionResponseDto[] = [];
    nonFunctionalRequirements : NonFunctionalRequirementResponseDto[] = [];

    constructor() {}
}

export function fromSystemsOfSystemsResponseDto(systemsOfSystemsResponseDto : SystemOfSystemsResponseDto[]) : SystemOfSystems[] {
    return systemsOfSystemsResponseDto.map(fromSystemOfSystemsResponseDto);
}

export function fromSystemOfSystemsResponseDto(systemOfSystemsResponseDto : SystemOfSystemsResponseDto) : SystemOfSystems {
    const systemOfSystems : SystemOfSystems = SystemOfSystems.create();

    systemOfSystems.system = fromSystemResponseDto(systemOfSystemsResponseDto.system);

    systemOfSystems.systemElementAggregates = fromSystemElementAggregatesResponseDto(systemOfSystemsResponseDto.systemElements);

    systemOfSystems.childSystems = fromSystemsOfSystemsResponseDto(systemOfSystemsResponseDto.childSystems ?? []);

    systemOfSystems.nonFunctionalRequirements = fromNonFunctionalRequirementsResponseDto(systemOfSystemsResponseDto.nonFunctionalRequirements);

    systemOfSystems.architecturalDecisions = fromArchitecturalDecisionsResponseDto(systemOfSystemsResponseDto.architecturalDecisions);

    return systemOfSystems;
}