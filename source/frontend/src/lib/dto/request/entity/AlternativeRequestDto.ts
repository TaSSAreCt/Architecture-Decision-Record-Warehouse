export class AlternativeRequestDto {
    id : string | undefined;
    title : string | undefined;

    constructor() {}

    static create() {
        return new AlternativeRequestDto();
    }
}