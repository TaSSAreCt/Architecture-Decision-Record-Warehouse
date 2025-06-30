export class AlternativeRequestDto {
    id : string = "";
    title : string = "";

    constructor() {}

    static create() {
        return new AlternativeRequestDto();
    }
}