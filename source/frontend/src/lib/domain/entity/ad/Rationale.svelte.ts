import {Alternative} from "$lib/domain/entity/ad/Alternative.svelte";


export class Rationale {

    id : string = $state<string>("");
    title: string = $state<string>("");
    context :  string = $state<string>("");
    decision : string = $state<string>("");
    status : string = $state<string>("");
    consequences : string = $state<string>("");

    justifies : string | undefined = $state<string | undefined>();

    static create() : Rationale {
        return new Rationale();
    }
    constructor() {}
}