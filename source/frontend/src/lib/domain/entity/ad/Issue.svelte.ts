import type {IssueResponseDto} from "$lib/dto/response/entity/IssueResponseDto";

export class Issue {

    id : string = $state("");
    title : string = $state("");

    constructor() {};

    static create(): Issue {
        return new Issue();
    }


    static fromJson = (issueResponseDto : IssueResponseDto) : Issue => {
        const issue = new Issue();

        issue.id = issueResponseDto.id;
        issue.title = issueResponseDto.title;

        return issue;
    }
}