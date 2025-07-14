import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";

export class SystemElement {

    id : string = $state("");
    title : string = $state("");
    constraints = $state<Constraint[]>([]);

    constructor() {
    }

    static create() {
        return new SystemElement();
    }

}