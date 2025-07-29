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

    constraintList : ConstraintResponseDto[] = [];
    nonFunctionalRequirementList : NonFunctionalRequirementResponseDto[] = [];
    architecturePrincipleList : ArchitecturePrincipleResponseDto[] = [];
    intentionList : IntentionResponseDto[] = [];
}

export function fromArchitecturalRequirementsResponseDto(architecturalRequirementsResponseDto : ArchitecturalRequirementsResponseDto) : ArchitecturalRequirements {

    const architecturalRequirements : ArchitecturalRequirements = ArchitecturalRequirements.create();

    architecturalRequirements.constraintList = fromConstraintListResponseDto(architecturalRequirementsResponseDto.constraintList);
    architecturalRequirements.nonFunctionalRequirementList = fromNonFunctionalRequirementsResponseDto(architecturalRequirementsResponseDto.nonFunctionalRequirementList);
    architecturalRequirements.intentionList = fromIntentionsResponseDto(architecturalRequirementsResponseDto.intentionList);
    architecturalRequirements.architecturePrincipleList = fromArchitecturalPrinciplesResponseDto(architecturalRequirementsResponseDto.architecturePrincipleList);

    return architecturalRequirements;

}