export class System {

    id : string = $state("");
    title : string = $state("");

    constructor() {}

    static create() : System {
        return new System();
    };
}