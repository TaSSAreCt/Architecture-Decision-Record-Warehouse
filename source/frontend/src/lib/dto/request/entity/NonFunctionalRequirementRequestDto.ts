export class NonFunctionalRequirementRequestDto {
    id : string = "";
    title : string = "";

    static create() {
        return new NonFunctionalRequirementRequestDto();
    }
}