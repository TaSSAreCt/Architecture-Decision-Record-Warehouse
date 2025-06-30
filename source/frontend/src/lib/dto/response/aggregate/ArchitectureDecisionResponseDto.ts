import {fromIssueResponseDto, IssueResponseDto} from "$lib/dto/response/entity/IssueResponseDto";
import { AlternativeAggregateResponseDto, fromAlternativeAggregatesResponseDto } from "$lib/dto/response/aggregate/AlternativeAggregateResponseDto";
import {ArchitectureDecision} from "$lib/domain/aggregate/ArchitectureDecision.svelte.js";

export class ArchitectureDecisionResponseDto {
    issue: IssueResponseDto = IssueResponseDto.create();
    alternativeAggregates : AlternativeAggregateResponseDto[] = [];
}

export function fromArchitecturalDecisionsResponseDto(architecturalDecisionsResponseDto : ArchitectureDecisionResponseDto[]) : ArchitectureDecision[] {
    return architecturalDecisionsResponseDto.map(fromArchitectureDecisionResponseDto);
}

export function fromArchitectureDecisionResponseDto(architectureDecisionResponseDto : ArchitectureDecisionResponseDto) : ArchitectureDecision {
    const architectureDecision : ArchitectureDecision = ArchitectureDecision.create();

    architectureDecision.issue = fromIssueResponseDto(architectureDecisionResponseDto.issue);
    architectureDecision.alternatives = fromAlternativeAggregatesResponseDto(architectureDecisionResponseDto.alternativeAggregates);

    return architectureDecision;

}