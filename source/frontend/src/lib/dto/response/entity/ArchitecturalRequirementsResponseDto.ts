import {
    ConstraintResponseDto,
    fromConstraintListResponseDto,
} from "$lib/dto/response/entity/ConstraintResponseDto";
import {
    fromNonFunctionalRequirementsResponseDto,
    NonFunctionalRequirementResponseDto
} from "$lib/dto/response/entity/NonFunctionalRequirementResponseDto";
import {
    ArchitecturePrincipleResponseDto,
    fromArchitecturalPrinciplesResponseDto
} from "$lib/dto/response/entity/ArchitecturePrincipleResponseDto";
import {fromIntentionsResponseDto, IntentionResponseDto} from "$lib/dto/response/entity/IntentionResponseDto";
import {ArchitecturalRequirements} from "$lib/domain/entity/ar/ArchitecturalRequirements.svelte.js";

export class ArchitecturalRequirementsResponseDto {

    constraints : ConstraintResponseDto[] = [];
    nonFunctionalRequirements : NonFunctionalRequirementResponseDto[] = [];
    architecturalPrinciples : ArchitecturePrincipleResponseDto[] = [];
    intentions : IntentionResponseDto[] = [];
}

export function fromArchitecturalRequirementsResponseDto(architecturalRequirementsResponseDto : ArchitecturalRequirementsResponseDto) : ArchitecturalRequirements {

    const architecturalRequirements : ArchitecturalRequirements = ArchitecturalRequirements.create();

    architecturalRequirements.constraintList = fromConstraintListResponseDto(architecturalRequirementsResponseDto.constraints);
    architecturalRequirements.nonFunctionalRequirementList = fromNonFunctionalRequirementsResponseDto(architecturalRequirementsResponseDto.nonFunctionalRequirements);
    architecturalRequirements.intentionList = fromIntentionsResponseDto(architecturalRequirementsResponseDto.intentions);
    architecturalRequirements.architecturePrincipleList = fromArchitecturalPrinciplesResponseDto(architecturalRequirementsResponseDto.architecturalPrinciples);

    return architecturalRequirements;

}