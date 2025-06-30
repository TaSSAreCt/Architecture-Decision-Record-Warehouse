import {NonFunctionalRequirement} from "$lib/domain/entity/ar/NonFunctionalRequirement.svelte.js";

export class NonFunctionalRequirementResponseDto {
    id : string = "";
    title : string = "";
}

export function fromNonFunctionalRequirementsResponseDto(nonFunctionalRequirementsResponseDto : NonFunctionalRequirementResponseDto[]) : NonFunctionalRequirement[] {
    return nonFunctionalRequirementsResponseDto.map(fromNonFunctionalRequirementResponseDto);
}

export function fromNonFunctionalRequirementResponseDto(nonFunctionalRequirementResponseDto : NonFunctionalRequirementResponseDto) : NonFunctionalRequirement {
    const nonFunctionalRequirement : NonFunctionalRequirement = NonFunctionalRequirement.create();

    nonFunctionalRequirement.id = nonFunctionalRequirementResponseDto.id;
    nonFunctionalRequirement.title = nonFunctionalRequirementResponseDto.title;

    return nonFunctionalRequirement;
}