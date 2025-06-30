export class SystemClassRequestDto {

    id : string = "";
    title : string = "";

    constructor() {}

    static create() {
        return new SystemClassRequestDto();
    }
}