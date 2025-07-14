
export class Rationale {

    id : string = $state<string>("");
    title: string = $state<string>("");
    context :  string = $state<string>("");
    decision : string = $state<string>("");
    status : string = $state<string>("");
    consequences : string = $state<string>("");

    constructor() {
    }

    static create() {
        return new Rationale();
    }
}