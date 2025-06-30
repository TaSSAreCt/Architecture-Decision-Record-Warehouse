import type {IssueRequestDto} from "$lib/dto/request/entity/IssueRequestDto";
import type {AlternativeAggregateRequestDto} from "$lib/dto/request/aggregate/AlternativeAggregateRequestDto";

export class ArchitecturalKnowledgeRequestDto {
    issue: IssueRequestDto;
    alternatives: AlternativeAggregateRequestDto[];

    constructor(issue : IssueRequestDto, alternatives : AlternativeAggregateRequestDto[]) {
        this.issue = issue;
        this.alternatives = alternatives;
    }

    static create(issue : IssueRequestDto, alternatives : AlternativeAggregateRequestDto[]) {
        return new ArchitecturalKnowledgeRequestDto(issue, alternatives);
    }
}