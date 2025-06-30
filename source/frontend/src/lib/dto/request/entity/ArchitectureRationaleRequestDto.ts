export class ArchitectureRationaleRequestDto {
    id : string = "";
    title : string = "";
    context : string = "";
    decision : string = "";
    status : string = "";
    consequences : string = "";

    constructor() {}

    static create() {
        return new ArchitectureRationaleRequestDto();
    }

}