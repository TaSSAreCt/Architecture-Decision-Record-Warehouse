import {Rationale} from "$lib/domain/entity/ad/Rationale.svelte";
import type {Influence} from "$lib/domain/entity/ad/Influence.svelte";

export class Alternative {
    id : string = $state("");
    title : string = $state("");
    rationaleList : Rationale[] = $state([]);
    influenceList : Influence[] = $state([]);

    constructor() {
    }

    static create() : Alternative {
        return new Alternative();
    }
}