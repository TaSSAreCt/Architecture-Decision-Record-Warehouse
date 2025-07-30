import {Issue} from "$lib/domain/entity/ad/Issue.svelte.js";
import {
    type AlternativeResponseDto,
    fromAlternativeListResponseDto
} from "$lib/dto/response/entity/AlternativeResponseDto";

export class IssueResponseDto {
    id: string;
    title: string;
    alternativeList : AlternativeResponseDto[] = [];

    constructor(id: string, title : string) {
        this.id = id;
        this.title = title;
    }
}

export function fromIssueListResponseDto(issueListResponseDto : IssueResponseDto[]) : Issue[] {
    return issueListResponseDto.map(fromIssueResponseDto);
}

export function fromIssueResponseDto(issueResponseDto : IssueResponseDto, rationale : boolean) : Issue {
    const issue : Issue = Issue.create();

    issue.id = issueResponseDto.id;
    issue.title = issueResponseDto.title;

    issue.alternativeList = fromAlternativeListResponseDto(issueResponseDto.alternativeList);

    return issue;
}