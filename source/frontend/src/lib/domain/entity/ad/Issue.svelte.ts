import type {Alternative} from "$lib/domain/entity/ad/Alternative.svelte";

export class Issue {

    id : string = $state("");
    title : string = $state("");
    alternativeList : Alternative[] = $state([]);

    constructor() {};

    static create(): Issue {
        return new Issue();
    }
}