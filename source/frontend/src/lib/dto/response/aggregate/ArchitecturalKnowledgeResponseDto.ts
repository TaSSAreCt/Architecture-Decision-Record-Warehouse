import {
    type ArchitectureDecisionResponseDto,
    fromArchitecturalDecisionsResponseDto
} from "$lib/dto/response/aggregate/ArchitectureDecisionResponseDto";
import {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte.js";

export function fromArchitecturalKnowledgeResponseDto(architecturalKnowledgeResponseDto : ArchitectureDecisionResponseDto[]) : ArchitecturalKnowledge {
    const architecturalKnowledge : ArchitecturalKnowledge = ArchitecturalKnowledge.create();

    architecturalKnowledge.architecturalDecisions = fromArchitecturalDecisionsResponseDto(architecturalKnowledgeResponseDto);

    return architecturalKnowledge;
}

