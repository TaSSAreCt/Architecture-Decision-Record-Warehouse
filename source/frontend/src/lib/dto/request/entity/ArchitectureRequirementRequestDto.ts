export class ArchitectureRequirementRequestDto {

    id : string = "";
    title : string = "";
    type : string = "";

    static create() {
        return new ArchitectureRequirementRequestDto();
    }
}