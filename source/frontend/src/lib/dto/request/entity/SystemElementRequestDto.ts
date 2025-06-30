export class SystemElementRequestDto {
    id : string = "";
    title : string = "";

    constructor() {}

    static create() {
        return new SystemElementRequestDto();
    }
}