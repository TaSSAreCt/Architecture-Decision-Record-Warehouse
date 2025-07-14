import {Rationale} from "$lib/domain/entity/ad/Rationale.svelte";
import {Influence} from "$lib/domain/entity/ad/Influence.svelte";

export class Alternative {

    id : string | undefined = $state<string | undefined>();
    title : string | undefined = $state<string | undefined>();
    rationaleList : Rationale[] = $state<Rationale[]>([]);
    influenceList : Influence[] = $state<Influence[]>([]);

    constructor() {
    }

    static create() : Alternative {
        return new Alternative();
    }
}