import {Issue} from "$lib/domain/entity/ad/Issue.svelte.js";

export class IssueResponseDto {
    id: string;
    title: string;

    constructor(id: string, title : string) {
        this.id = id;
        this.title = title;
    }

    static create() {
        return new IssueResponseDto("", "");
    }
}

export function fromIssueResponseDto(issueResponseDto : IssueResponseDto) : Issue {
    const issue : Issue = Issue.create();

    issue.id = issueResponseDto.id;
    issue.title = issueResponseDto.title;

    return issue;
}