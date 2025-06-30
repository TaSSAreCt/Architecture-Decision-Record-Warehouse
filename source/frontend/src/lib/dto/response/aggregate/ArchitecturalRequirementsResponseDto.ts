import {ConstraintResponseDto, fromConstraintsResponseDto} from "$lib/dto/response/entity/ConstraintResponseDto";
import {
    fromNonFunctionalRequirementsResponseDto,
    NonFunctionalRequirementResponseDto
} from "$lib/dto/response/entity/NonFunctionalRequirementResponseDto";
import {
    ArchitecturePrincipleResponseDto,
    fromArchitecturalPrinciplesResponseDto
} from "$lib/dto/response/entity/ArchitecturePrincipleResponseDto";
import {fromIntentionsResponseDto, IntentionResponseDto} from "$lib/dto/response/entity/IntentionResponseDto";
import {ArchitecturalRequirements} from "$lib/domain/aggregate/ArchitecturalRequirements.svelte";

export class ArchitecturalRequirementsResponseDto {

    constraints : ConstraintResponseDto[] = [];
    nonFunctionalRequirements : NonFunctionalRequirementResponseDto[] = [];
    architecturalPrinciples : ArchitecturePrincipleResponseDto[] = [];
    intentions : IntentionResponseDto[] = [];
}

export function fromArchitecturalRequirementsResponseDto(architecturalRequirementsResponseDto : ArchitecturalRequirementsResponseDto) : ArchitecturalRequirements {

    const architecturalRequirements : ArchitecturalRequirements = ArchitecturalRequirements.create();

    architecturalRequirements.constraints = fromConstraintsResponseDto(architecturalRequirementsResponseDto.constraints);
    architecturalRequirements.nonFunctionalRequirements = fromNonFunctionalRequirementsResponseDto(architecturalRequirementsResponseDto.nonFunctionalRequirements);
    architecturalRequirements.intentions = fromIntentionsResponseDto(architecturalRequirementsResponseDto.intentions);
    architecturalRequirements.architecturalPrinciples = fromArchitecturalPrinciplesResponseDto(architecturalRequirementsResponseDto.architecturalPrinciples);

    return architecturalRequirements;

}