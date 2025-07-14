import {Rationale} from "$lib/domain/entity/ad/Rationale.svelte";

export class Madr extends Rationale {
    id : string = $state<string>("");
    title: string = $state<string>("");
    context :  string = $state<string>("");
    decision : string = $state<string>("");
    status : string = $state<string>("");
    consequences : string = $state<string>("");

    constructor() {
        super();
    }

    get() : string {
        return "";
    }

    static create() {
        return new Madr();
    }
}