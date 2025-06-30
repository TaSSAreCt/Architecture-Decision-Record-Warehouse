export class Alternative {
    id : string = $state("");
    title : string = $state("");

    constructor() {
    }

    static create() : Alternative {
        return new Alternative();
    }
}