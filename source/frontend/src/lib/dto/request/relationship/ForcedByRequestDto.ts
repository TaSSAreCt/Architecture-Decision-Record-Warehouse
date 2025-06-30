export class ForcedByRequestDto {
    id: string;
    title: string;
    type: string;
    value: number;

    constructor(id : string, title : string, type : string, value : number) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.value = value;
    }

    static create(id : string, title : string, type : string, value : number) {
        return new ForcedByRequestDto(id, title, type, value);
    }
}