import {Constraint} from "$lib/domain/entity/ar/Constraint.svelte";

export class SystemElement {

    id : string | undefined = $state();
    title : string | undefined = $state();
    constraints = $state<Constraint[]>([]);

    constructor() {
    }

    static create() {
        return new SystemElement();
    }

}