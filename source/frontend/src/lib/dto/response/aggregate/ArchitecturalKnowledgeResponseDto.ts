import {ArchitecturalKnowledge} from "$lib/domain/aggregate/ArchitecturalKnowledge.svelte.js";
import {fromIssueListResponseDto, type IssueResponseDto} from "$lib/dto/response/entity/IssueResponseDto";

export function fromArchitecturalKnowledgeResponseDto(architecturalKnowledgeResponseDto : IssueResponseDto[]) : ArchitecturalKnowledge {
    const architecturalKnowledge : ArchitecturalKnowledge = ArchitecturalKnowledge.create();

    architecturalKnowledge.issueList = fromIssueListResponseDto(architecturalKnowledgeResponseDto);

    return architecturalKnowledge;
}

