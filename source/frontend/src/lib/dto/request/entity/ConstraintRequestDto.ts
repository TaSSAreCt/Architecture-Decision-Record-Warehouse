export class ConstraintRequestDto {
    id : string = "";
    title : string = "";

    static create() {
        return new ConstraintRequestDto();
    }
}