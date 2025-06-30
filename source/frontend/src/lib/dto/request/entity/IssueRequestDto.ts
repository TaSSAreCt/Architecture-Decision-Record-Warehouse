export class IssueRequestDto {
    id : string = "";
    title : string = "";

    constructor() {
    }

    static create() {
        return new IssueRequestDto();
    }
}